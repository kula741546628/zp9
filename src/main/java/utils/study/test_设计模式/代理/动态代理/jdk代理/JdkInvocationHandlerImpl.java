package utils.study.test_设计模式.代理.动态代理.jdk代理;


import utils.study.test_设计模式.代理.静态代理.UserDao;
import utils.study.test_设计模式.代理.静态代理.UserDaoImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author kula
 * @create 2021/5/9 下午5:00
 */
public class JdkInvocationHandlerImpl implements InvocationHandler {

    private Object target;

    public JdkInvocationHandlerImpl(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("动态代理执行前……");
        Object invoke = method.invoke(target, args);
        System.out.println("动态代理执行后……");
        return invoke;
    }

    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        JdkInvocationHandlerImpl jdkInvocationHandler = new JdkInvocationHandlerImpl(userDao);
        ClassLoader classLoader = userDao.getClass().getClassLoader();
        Class<?>[] interfaces = userDao.getClass().getInterfaces();
        UserDao newProxyInstance = (UserDao)Proxy.newProxyInstance(classLoader, interfaces, jdkInvocationHandler);
        newProxyInstance.add();
    }
}
