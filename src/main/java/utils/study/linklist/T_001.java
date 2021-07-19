package utils.study.linklist;

import com.google.common.collect.Lists;

import java.util.LinkedList;

/**
 * @Author kula
 * @create 2021/7/12 下午9:29
 */
public class T_001 {
    public static void main(String[] args) {
        LinkedList linkedList = Lists.newLinkedList();
        String s = "1";
        String s1 = "2";
        linkedList.add(s);
        linkedList.add(s1);
        linkedList.get(1);
    }
}
