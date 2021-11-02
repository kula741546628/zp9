package utils.study.map_study.HashMap_study;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author kula
 * @create 2021/10/3 下午8:22
 * lru缓存淘汰策略算法
 */
public class LruCache<K,V> extends LinkedHashMap<K,V> {
    private int capacity;

    public LruCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        LruCache lruCache = new LruCache(3);
        lruCache.put("a", "a");
        lruCache.put("b", "b");
        lruCache.put("c", "c");
        lruCache.put("d", "d");

        lruCache.forEach((k,v)-> System.out.println(k+","+v));
    }
}
