package cn.xiejx.jfun.config.shiro;


import cn.xiejx.jfun.entity.User;
import cn.xiejx.jfun.service.UserService;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    //获取认证信息
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String name  = (String) authenticationToken.getPrincipal();
        User user = userService.findByName(name);
        if (user == null) return null;
        if(user.getState() == 0){
            throw new LockedAccountException();//账户冻结
        }

        return new SimpleAuthenticationInfo(
                user, user.getPassword(), ByteSource.Util.bytes(user.getCredentialsSalt()),
                getName()
        );
    }

    //获取授权信息
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {


        Object key = principalCollection.getPrimaryPrincipal();
        User user=new User();
        try {
            BeanUtils.copyProperties(user, key);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //User user = (User) principalCollection.getPrimaryPrincipal();这段代码启用了热部署以后使用不了!!

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //使用基于角色的权限控制(前后端都做了权限控制，后端代码禁止使用role进行权限控制。把role当成权限的容器，没有实质的作用！！！
        Set<String> roles = userService.findRoleByUser(user.getName());
        Set<String> permissions = userService.findPermissionByUser(user.getName());
        authorizationInfo.setRoles(roles);
        authorizationInfo.setStringPermissions(permissions);
        return authorizationInfo;
    }

}
