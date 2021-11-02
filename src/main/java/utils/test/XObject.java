package utils.test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author kula
 * @create 2021/10/7 上午11:34
 */
public class XObject {
    public final static Map<Integer,XObject> map= Collections.synchronizedMap(new HashMap<Integer,XObject>()); //它是一个Map,并且线程安全
    public static XObject getObjectByRawHashCode(Integer hashCode){
        return map.get(hashCode);
    }
    /**hashCode()方法是Object类下面的一个方法，供继承类重写，根据对象内存地址计算哈希值    ，
     * String类重写了hashCode方法，并改为根据字符序列来计算哈希值,
     * identityHashCode()方法是System类中的静态方法，根据对象内存地址来计算哈希值；
     * **/
    XObject(){
        map.put(System.identityHashCode(this), this);
    }

}
