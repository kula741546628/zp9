package utils.study.test_多线程.thread_demo3.zpFuture;

import java.util.concurrent.locks.LockSupport;

/**
 * @Author kula
 * @create 2021/6/7 下午10:52
 */
public class ExtFutureTask<V> implements Runnable {
    private ExtCallable<V> callable;
    private Object objectLock = new Object();
    private Thread cuThread;
    private Object result;

    public ExtFutureTask(ExtCallable<V> callable){
        this.callable = callable;
    }

    @Override
    public void run() {
        result = callable.call();
//        if (cuThread != null) {
            LockSupport.unpark(cuThread);
//        }
//        synchronized (objectLock) {
//            objectLock.notifyAll();
//        }
    }


    public Object get(){
//        synchronized (objectLock) {
//            try {
//                objectLock.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cuThread = Thread.currentThread();
        LockSupport.park();
        return result;
    }
}
