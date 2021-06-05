package utils.study.test_设计模式.反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author kula
 * @create 2021/5/8 下午5:52
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        Class<?> forName = Class.forName("test_设计模式.反射.UserEntity");
        UserEntity userEntity1  = (UserEntity) forName.newInstance();
        Method[] methods = forName.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }

        Field[] declaredFields = forName.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field.getName());
        }

        Constructor<?> constructor = forName.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        UserEntity userEntity2 = (UserEntity)constructor.newInstance("名字");
    }
}
