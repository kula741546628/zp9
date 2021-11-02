package utils.study.jvm;

import java.util.Arrays;
import java.util.List;

/**
 * @Author kula
 * @create 2021/7/25 下午8:23
 * 类加载器：双亲委派机制
 * 作用：防止开发者定义的 类的名称（包名称+类目）与jdk官方提供的jar包的类名称f发生冲突
 */
public class T_001 {
    public static void main(String[] args) {
//        bootstrapClassLoader();
//        extClassLoader();
        appClassLoader();
    }

    /**
     * 应用类加载器目录是 启动类加载器+扩展类加载器+maven仓库里的jar
     * java
     */
    private static void appClassLoader() {
        String property = System.getProperty("java.class.path");
        List<String> list = Arrays.asList(property.split(":"));
        list.forEach(e->{
            System.out.println("应用类加载器目录："+e);
        });
    }

    /**
     * 扩展类加载器目录是home/jre/lib/ext
     * java
     */
    private static void extClassLoader() {
        String property = System.getProperty("java.ext.dirs");
        List<String> list = Arrays.asList(property.split(":"));
        list.forEach(e->{
            System.out.println("扩展类加载器目录："+e);
        });
    }

    /**
     * 启动类加载器的目录是home/jre/lib
     * C语音
     * 获取对象的类加载器为null
     */
    private static void bootstrapClassLoader() {
        String property = System.getProperty("sun.boot.class.path");
        List<String> list = Arrays.asList(property.split(":"));
        list.forEach(e->{
            System.out.println("启动类加载器目录："+e);
        });
    }
}
