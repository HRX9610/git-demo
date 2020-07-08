package org.web.auction.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.web.auction.pojo.User;
import org.web.auction.service.UserService;

import javax.jws.soap.SOAPBinding;

public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    //用户认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String username = (String) token.getPrincipal();
        System.out.println("账号："+ username);
        User user = userService.findUserByusername(username);
        if(user == null){
            return null;
        }
        String password_db = user.getUserpassword();
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,password_db,"ShiroRealm");
        return info;
    }
}
