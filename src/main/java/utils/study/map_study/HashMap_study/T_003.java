package utils.study.map_study.HashMap_study;

import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.TreeMap;

/**
 * @Author kula
 * @create 2021/10/1 下午10:00
 *
 * LinkedHashMap 双向链表 有序的 因为双向链表
 * TreeMap 树形结构，不能存key健为null。 有序的
 *
 */
public class T_003 {
    public static void main(String[] args) {



        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("a",1);

        System.out.println(linkedHashMap);



        TreeMap<Object, Object> treeMap = new TreeMap<>();
        treeMap.put(4,null);
        treeMap.put(1,1);
        treeMap.put(2,2);


        Hashtable<Object, Object> hashtable = new Hashtable<>();
        hashtable.put(2,3);
    }
}
