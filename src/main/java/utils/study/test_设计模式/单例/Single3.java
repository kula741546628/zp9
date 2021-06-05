package utils.study.test_设计模式.单例;

/**
 * @Author kula
 * @create 2021/5/8 下午9:50
 * 双重检测锁
 */
public class Single3 {

    private Single3(){

    }
    private static volatile Single3 single3;

    public synchronized static Single3 getSingle() {
        if (single3 == null) {
            synchronized (Single3.class) {
                if (single3 == null) {
                    single3 =  new Single3();
                }
            }
        }
        return single3;
    }


}
