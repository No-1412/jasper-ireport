package com.kingdom.proxy;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * @author No.1412
 * @version 2018/5/28
 */
public class CglibProxy implements MethodInterceptor {

    private static final transient Logger logger = LoggerFactory.getLogger(CglibProxy.class);

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        logger.info("进入cglib代理 -> {}", method.getName());
//        BaseService baseService = (BaseService) o;
        Object result = methodProxy.invokeSuper(o, objects);
//        if (!"close".equals(method.getName()) && !"UserService".equals(method.getName()))
//            baseService.close();
        logger.info("结束cglib代理 -> {}", methodProxy.getSuperName());
        return result;
    }

    /**
     * 封装代理方法
     */
    public static  <T> T createByAgent(Class<T> superclass) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(superclass);
        enhancer.setCallback(new CglibProxy());
        return (T) enhancer.create();
    }
}
