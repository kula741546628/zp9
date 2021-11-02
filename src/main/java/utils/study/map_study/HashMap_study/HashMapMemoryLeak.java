package utils.study.map_study.HashMap_study;

import java.util.HashMap;

/**
 * @Author kula
 * @create 2021/10/1 下午5:56
 * map 内存泄漏演示
 */

public class HashMapMemoryLeak {
    public static void main(String[] args) {
        HashMap<Object, Object> map = new HashMap<>(1000);
        int count = 0;
        while (true) {
            HashKey hashKey = new HashKey();
            hashKey.setId(1);
            hashKey.setName("zp");
            map.put(hashKey, 1);
            count++;
            if (count%1000==0){
                System.out.println("map size:"+ map.size());
                System.out.println("运行"+count+"次后，可用内存剩余"
                        +Runtime.getRuntime().freeMemory()/1024/1024+"MB");
            }

        }

    }
}
//@Data
class HashKey{
    private int id;
    private String name;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}