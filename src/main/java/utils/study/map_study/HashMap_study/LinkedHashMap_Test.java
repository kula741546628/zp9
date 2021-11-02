package utils.study.map_study.HashMap_study;

import java.util.LinkedHashMap;

/**
 * @Author kula
 * @create 2021/10/1 下午10:41
 * hashMap是无序存放；
 * LinkedHashMap是有序存放，
 *
 * 有序性：存放顺序按照先后顺序存放，不是key的大小
 */
public class LinkedHashMap_Test {
    public static void main(String[] args) {
//        HashMap<Object, Object> hashMap = new HashMap<>();
//        for (int i = 0; i < 100; i++) {
//            hashMap.put(i+"", i+"");
//        }
//        hashMap.forEach((k,v)-> System.out.println(k+","+v));

//        LinkedHashMapForFalse();


        LinkedHashMapForTrue();


    }

    private static void LinkedHashMapForTrue() {
        /**
         * accessOrder = true;意思是会根据get方法和put方法而改变顺序
         */
        LinkedHashMap<Object, Object> linkedHashMapForTure = new
                LinkedHashMap<Object, Object>(16, 0.75f, true);
        linkedHashMapForTure.put("a", "a");
        linkedHashMapForTure.put("b", "b");
        linkedHashMapForTure.put("c", "c");
        linkedHashMapForTure.put("a", "aaa");
        linkedHashMapForTure.get("b");
        linkedHashMapForTure.forEach((k,v)-> System.out.println(k+","+v));
    }

    private static void LinkedHashMapForFalse() {
        /**
         * linkedHashMap 按照新增的顺序排序
         * 默认accessOrder = false;意思是不会根据get方法和put覆盖原有元素而改变顺序
         *
         */
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<>();
        for (int i = 1; i < 100; i++) {
            linkedHashMap.put(i+"", i+"");
        }
        linkedHashMap.put(0,0);
        linkedHashMap.forEach((k,v)-> System.out.println(k+","+v));

    }
}
