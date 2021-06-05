package utils.study.test_设计模式.单例;

/**
 * @Author kula
 * @create 2021/5/8 下午9:50
 * 懒汉式
 */
public class Single2 {

    private Single2(){

    }
    private static Single2 single2;

    public synchronized static Single2 getSingle() {
        if (single2 == null) {
            single2 =  new Single2();
        }
        return single2;
    }


}
