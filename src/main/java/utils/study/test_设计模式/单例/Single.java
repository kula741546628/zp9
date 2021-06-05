package utils.study.test_设计模式.单例;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author kula
 * @create 2021/5/8 下午9:50
 * 饿汉式
 */
public class Single {

    private Single(){
        synchronized (Single.class) {
            System.out.println("flag:" + FLAG);
            if (FLAG == false) {
                FLAG = true ;
            } else {
                throw new RuntimeException("该对象是单列的，不能重复创建");
            }
            System.out.println("Single对象"+ FLAG);
        }

    }
    private final static Single single = new Single();
    private static boolean FLAG = false;

    public static Single getSingle() {
        return single;
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        Single single = Single.getSingle();
        Class<?> forName = Class.forName("test_设计模式.单例.Single");
        Constructor<?> declaredConstructor = forName.getDeclaredConstructor(null);
//        declaredConstructor.setAccessible(true);

        Object o = declaredConstructor.newInstance();
    }

}
