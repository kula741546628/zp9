package utils.study.test_设计模式.单例;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author kula
 * @create 2021/5/8 下午9:56
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Single single = Single.getSingle();
//        Single single1 = Single.getSingle();

        Class<?> forName = Class.forName("test_设计模式.单例.Single");
        Constructor<?> declaredConstructor = forName.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        Object o = declaredConstructor.newInstance();

//        System.out.println(single == single1);
//        System.out.println(single == o);
    }
}
