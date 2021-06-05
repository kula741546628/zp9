package utils.study.test_设计模式.代理.动态代理.cglib代理;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import utils.study.test_设计模式.代理.静态代理.UserDaoImpl;

import java.lang.reflect.Method;

/**
 * @Author kula
 * @create 2021/5/9 下午10:00
 */
public class CgLib implements MethodInterceptor {

    private Object targetObject;

    public Object getInstance(Object targetObject){
        this.targetObject = targetObject;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(targetObject.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib动态代理执行前……");
        Object invoke = methodProxy.invoke(targetObject, objects);
        System.out.println("cglib动态代理执行后……");
        return invoke;
    }


    public static void main(String[] args) {
        CgLib cgLib = new CgLib();
        UserDaoImpl userDaoImpl = (UserDaoImpl)cgLib.getInstance(new UserDaoImpl());
        userDaoImpl.add();
    }
}
