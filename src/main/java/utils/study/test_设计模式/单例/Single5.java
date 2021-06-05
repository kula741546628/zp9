package utils.study.test_设计模式.单例;

/**
 * @Author kula
 * @create 2021/5/9 下午12:53
 * 内部类
 */
public class Single5 {

    private Single5(){
        System.out.println("初始化");
    }
    public static class SingletonClassInstance {
        private static final Single5 single5 = new Single5();
    }

    // 方法没有同步
    public static Single5 getSingle5() {
        return SingletonClassInstance.single5;
    }

    public static void main(String[] args) {
        Single5 s1 = Single5.getSingle5();
        Single5 s2 = Single5.getSingle5();
        System.out.println(s1 == s2);
    }
}
