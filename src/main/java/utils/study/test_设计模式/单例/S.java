package utils.study.test_设计模式.单例;

/**
 * @Author kula
 * @create 2021/5/9 下午4:14
 * 单例测试
 */
public class S {
    private S() {

    }

    private static class SS {
        private final static S s = new S();
    }

    public static S getS() {
        return SS.s;
    }


}
