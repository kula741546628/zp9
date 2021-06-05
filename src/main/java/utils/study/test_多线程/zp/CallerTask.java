package utils.study.test_多线程.zp;

import java.util.concurrent.Callable;

/**
 * @Author kula
 * @create 2021/4/26 下午10:19
 */
public class CallerTask implements Callable {
    @Override
    public Object call() throws Exception {
        String s = "zp";
        return s;
    }
}
