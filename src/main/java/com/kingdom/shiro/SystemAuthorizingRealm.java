package com.kingdom.shiro;

import com.kingdom.model.User;
import com.kingdom.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author No.1412
 * @version 2018/6/30
 */
public class SystemAuthorizingRealm extends AuthorizingRealm {
    private static final transient Logger logger = LoggerFactory.getLogger(AuthorizingRealm.class);

//    private static final String password = "d6f19f1e0a0102a759af2ca552225b598f1e9218e4853024c4b19dba6f3ef36b1969bea08eeb3112";

    @Autowired
    private UserService userService;

    protected User getUser(PrincipalCollection principals) {
        return (User) this.getAvailablePrincipal(principals);
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        logger.info("开始授权了-> {}", principals);
        User user = this.getUser(principals);
        System.out.println(user.getName());

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRole("ccccccccccc");


        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        logger.info("开始认证了 Credentials-> {}, Principal-> {}",
                token.getCredentials(), token.getPrincipal());
        logger.info("name-> {}", getName());

        //使用mybatis获取已存在用户完成认证
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
//        UserService userService = CglibProxy.createByAgent(UserService.class);
        User user = userService.findByUsername(userToken.getUsername());
        if (user != null) {
            logger.info("当前登录用户-> {} \n密码-> {}",
                    user.getLoginName(), user.getPassword());
            String salt = user.getPassword().substring(0, 16);
            return new SimpleAuthenticationInfo(user, user.getPassword().substring(16),
                    ByteSource.Util.bytes(Hex.decode(salt)), getName());
        }

        return null;
    }

}
