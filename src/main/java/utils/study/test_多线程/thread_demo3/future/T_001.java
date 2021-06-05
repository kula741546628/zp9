package utils.study.test_多线程.thread_demo3.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author kula
 * @create 2021/5/5 下午5:26
 */
public class T_001 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
//        Future<String> submit = newCachedThreadPool.submit(new CallableTest());
//        String result = submit.get();
//        System.out.println(result);

        FutureTask<String> future = new FutureTask(new CallableTest());
        Thread thread = new Thread(future);
        thread.start();
        String s = future.get();
//        System.out.println(s);

        FutureTask<Integer> futureTask = new FutureTask<Integer>(() -> 1);
//        new Thread(futureTask).start();
        Integer integer = futureTask.get();
        System.out.println(integer);


        new Thread(new RunTest()).start();
        new Thread(new FutureTask<String>(new CallableTest())).start();

        new Thread(() -> {
            System.out.println("子线程");
        }).start();
        FutureTask<String> futureTask1 = new FutureTask<String>(() -> {
            return "子线程";
        });
        new Thread(futureTask1).start();
        String s1 = futureTask1.get();

    }
}

class CallableTest implements Callable<String>{

    @Override
    public String call() throws Exception {
        return "zp";
    }
}

class RunTest implements Runnable {

    @Override
    public void run() {
        System.out.println("子线程");
    }
}