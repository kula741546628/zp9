package utils.study.test_多线程.thread_demo3.future;

import java.util.concurrent.*;

/**
 * @Author kula
 * @create 2021/5/5 下午6:12
 */
public class T_002 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("主线程执行开始");
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        Future<String> submit = newCachedThreadPool.submit(new CallTast());
        submit.get();
        newCachedThreadPool.execute(new RunT());


        System.out.println("主线程执行结束");


    }
}
class CallTast implements Callable<String>{

    @Override
    public String call() throws Exception {
        System.out.println("call执行中……");
        Thread.sleep(3000);
        System.out.println("call执行结束");
        return "zps";
    }
}

class RunT implements Runnable{

    @Override
    public void run() {
        System.out.println("run执行中……");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("run执行结束");
    }
}