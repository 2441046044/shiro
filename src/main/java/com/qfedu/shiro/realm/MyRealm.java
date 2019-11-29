package com.qfedu.shiro.realm;



import com.qfedu.shiro.entity.User;
import com.qfedu.shiro.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

import java.util.HashSet;
import java.util.List;


public class MyRealm extends AuthorizingRealm {

    @Autowired
    @Lazy  //使用redis缓存shiro中数据时，需要使用该注解
    private UserService userService;
    //获取权限信息
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取合法的用户的用户名
        String name = (String)principalCollection.getPrimaryPrincipal();
        //查询拥有的权限
        List<String> permsList = userService.findPermsByName(name);

        //创建授权信息对象
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        info.setStringPermissions(new HashSet<>(permsList));

        return info;
    }


    //获取认证信息
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取用户身份信息
        String name = (String)authenticationToken.getPrincipal();

        User user = userService.findUserByName(name);

        SimpleAuthenticationInfo info = null;
        if (user == null){
            info = new SimpleAuthenticationInfo("","",this.getName());
        }else {
            // 身份认证的 信息对象
            //第一个参数，用户身份信息  用户名
            //第二个参数，用户凭证信息  密码
            //打三个参数：realm的名称
            //info = new SimpleAuthenticationInfo(name, user.getPassword(), this.getName());

            //如果md5中使用了盐值，需要找认证信息对象设置盐值
            info = new SimpleAuthenticationInfo(name, user.getPassword(), ByteSource.Util.bytes("haha"), this.getName());

        }
        return info;
    }


    public static void main(String[] args) {
        SimpleHash simpleHash = new SimpleHash("md5", "234", "haha", 1);
        System.out.println(simpleHash.toHex());
    }


}
