package utils.study.线程池;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Author kula
 * @create 2021/9/24 下午8:48
 */
public class MyExecutors {
    private List<WorkThread> workList;
    private BlockingQueue<Runnable> runnables;
    public MyExecutors (int maxThreadCount, int queueSize){
        workList = new ArrayList<>(maxThreadCount);
        runnables = new LinkedBlockingDeque<>(queueSize);
        for (int i = 0; i < maxThreadCount; i++) {
            new WorkThread().start();
        }
    }
    class WorkThread extends Thread{
        @Override
        public void run() {
            while (true) {
                Runnable runnable = runnables.poll();
                if (runnable != null) {
                    runnable.run();
                }
            }
        }
    }
    public boolean executor(Runnable runnable) {
        boolean b = runnables.offer(runnable);
        System.out.println(b);
        return b;
    }
    public static void main(String[] args) {
        MyExecutors myExecutors = new MyExecutors(2, 2);
        for (int i = 0; i < 10; i++) {
            final int finalI = i;
            myExecutors.executor(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "->" + finalI);
                }
            });
        }
    }
}
