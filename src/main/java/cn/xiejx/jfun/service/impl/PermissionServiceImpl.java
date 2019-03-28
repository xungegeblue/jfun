package cn.xiejx.jfun.service.impl;

import cn.xiejx.jfun.dao.PermissionMapper;
import cn.xiejx.jfun.entity.Permission;
import cn.xiejx.jfun.service.PermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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

    @Override
    public Object getPermissionTree(List<Permission> permissions) {
        //TODO 待优化
        List<Map<String,Object>> list = new LinkedList<>();
        permissions.forEach(permission -> {
                    if (permission!=null){
                        List<Permission> permissionList = this.findByPid(permission.getId());
                        Map<String,Object> map = new HashMap<>();
                        map.put("id",permission.getId());
                        map.put("label",permission.getAlias());
                        if(permissionList!=null && permissionList.size()!=0){
                            map.put("children",getPermissionTree(permissionList));
                        }
                        list.add(map);
                    }
                }
        );
        return list;
    }
}
