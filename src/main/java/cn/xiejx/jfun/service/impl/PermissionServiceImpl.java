package cn.xiejx.jfun.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.xiejx.jfun.config.exection.BadRequestException;
import cn.xiejx.jfun.config.exection.EntityExistException;
import cn.xiejx.jfun.dao.PermissionMapper;
import cn.xiejx.jfun.entity.Permission;
import cn.xiejx.jfun.service.PermissionService;
import cn.xiejx.jfun.service.dto.PermissionDTO;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @Author 谢镜勋
 * @Date 2019/3/28
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

    @Override
    public List<Permission> findByPid(long pid) {

        return baseMapper.findByPid(pid);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Object getPermissionTree(List<Permission> permissions) {
        //TODO 待优化
        List<Map<String, Object>> list = new LinkedList<>();
        permissions.forEach(permission -> {
                    if (permission != null) {
                        List<Permission> permissionList = this.findByPid(permission.getId());
                        Map<String, Object> map = new HashMap<>();
                        map.put("id", permission.getId());
                        map.put("label", permission.getAlias());
                        if (permissionList != null && permissionList.size() != 0) {
                            map.put("children", getPermissionTree(permissionList));
                        }
                        list.add(map);
                    }
                }
        );
        return list;
    }


    @Override
    public List<PermissionDTO> getPermissionData(List<Permission> permissions) {
        List<PermissionDTO> list = new LinkedList<>();
        permissions.forEach(permission -> {
                    if (permission != null) {
                        PermissionDTO p = new PermissionDTO();
                        BeanUtils.copyProperties(permission, p);

                        List<Permission> permissionList = this.findByPid(permission.getId());

                        if (permissionList != null && permissionList.size() != 0) {
                            p.setChildren(getPermissionData(permissionList));
                        }
                        list.add(p);
                    }
                }
        );
        return list;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Permission create(Permission resource) {
        //在数据库层面做一些数据校验!
        if (baseMapper.selectByName(resource.getName()) != null) {
            throw new EntityExistException(Permission.class, "name", "该权限已经存在!");
        }
        //这个返回值用的很好!
        return baseMapper.insert(resource) > 0 ? resource : null;
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(Permission resource) {
        Permission permission1 = baseMapper.selectByName(resource.getName());
        //如果修改失败，抛出异常代替(此时无返回值)
        if (permission1 != null && !permission1.getId().equals(resource.getId())) {
            throw new EntityExistException(Permission.class, "name", resource.getName());//权限名称不可以重复
        }
        Permission dbPermission = baseMapper.selectById(resource.getId());
        if(dbPermission==null){
            throw new BadRequestException("权限不存在!");
        }
        dbPermission.setName(resource.getName());
        dbPermission.setAlias(resource.getAlias());
        dbPermission.setPid(resource.getPid());
        baseMapper.updateById(dbPermission);
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Long id) {
        baseMapper.deleteById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<Permission> queryAll(String name) {
        List<Permission> permissions = baseMapper.selectList(Wrappers.<Permission>lambdaQuery()
                .like(!StringUtils.isEmpty(name), Permission::getName, name));
        return permissions;
    }

    @Override
    public Object buildTree(List<PermissionDTO> permissions) {
        List<PermissionDTO> trees = new ArrayList<>();

        for (PermissionDTO pp : permissions) {


            if ("0".equals(pp.getPid().toString())) {
                trees.add(pp);
            }

            for (PermissionDTO it : permissions) {
                if (pp.getPid().equals(it.getId())) {
                    if (pp.getChildren() == null) {
                        pp.setChildren(new ArrayList<PermissionDTO>());
                    }
                    pp.getChildren().add(it);
                }
            }
        }
        //为了解决搜索的问题，这里做一点小变动
        Integer totalElements = trees.size() == 0 ? permissions.size() : trees.size();
        Map map = new HashMap();
        map.put("records", trees.size() == 0 ? permissions : trees);
        map.put("total", totalElements);
        return map;
    }
}
