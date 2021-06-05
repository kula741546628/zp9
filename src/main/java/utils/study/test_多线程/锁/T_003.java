package utils.study.test_多线程.锁;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author kula
 * @create 2021/5/6 下午9:49
 * 读写锁
 */
public class T_003 {
    public static void main(String[] args) {
        Cache1 cache1 = new Cache1();
        new Thread(()-> {
            for (int i = 0; i < 10; i++) {
                cache1.put(i+"", i+"");
            }

        }).start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                cache1.get(i+"");
            }
        }).start();

    }
}

class Cache1{

    private Map<String, String> cache = new HashMap<>();
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private Lock writeLock = readWriteLock.writeLock();
    private Lock readLock = readWriteLock.readLock();

    public void put(String key, String value) {

        writeLock.lock();

        try {
            System.out.println("写入put方法 ,key:" + key + ",value:" + value + "开始.");
            Thread.sleep(100);
            cache.put(key,value);
            System.out.println("写入put方法 ,key:" + key + ",value:" + value + "结束.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }

    }

    public String get(String key) {
        readLock.lock();

        try {
            System.out.println("读取,key:" + key + " 开始");
            Thread.sleep(100);
            String value = cache.get(key);
            System.out.println("读取,key:" + key + " 结束");
            return value;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            readLock.unlock();
        }
        return null;
    }


}
