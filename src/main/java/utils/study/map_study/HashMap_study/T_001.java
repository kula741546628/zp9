package utils.study.map_study.HashMap_study;

import lombok.Data;

import java.util.HashMap;

/**
 * @Author kula
 * @create 2021/9/29 下午3:51
 * HashMap  无序的因为单项链表
 * hashMap在多线程的情况下会导致死循环，因为头插法
 */
@Data
public class T_001 {
    private String key;
    public static void main(String[] args) {
        String A = "a";//"97";
        Integer B = 97;
        System.out.println(A.equals(B));
        System.out.println(A.hashCode());
        System.out.println(B.hashCode());
        HashMap<Object, Object> hashMap = new HashMap<>();
//        Object o = hashMap.put(null, 1);
//        Object o1 = hashMap.put(null, 2);
//        System.out.println(o);
        hashMap.put(A,"a");
        hashMap.put(B,97);
        hashMap.put(B,"a1");
        System.out.println(hashMap.size());
        /**
         *  modCount 用来比较map遍历前和遍历后是否一致
         */
        hashMap.forEach((k,v) -> {
            System.out.println(v);
        });

    }

}
