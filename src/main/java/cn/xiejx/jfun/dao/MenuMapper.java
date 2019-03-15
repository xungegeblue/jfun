package cn.xiejx.jfun.dao;

import cn.xiejx.jfun.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**菜单
 * @Author 谢镜勋
 * @Date 2019/3/15
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {
    public List<Menu> getMenuByRole(Integer roleId);
}
