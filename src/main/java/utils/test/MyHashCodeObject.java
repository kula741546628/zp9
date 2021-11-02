package utils.test;

/**
 * @Author kula
 * @create 2021/10/7 上午11:34
 */
public class MyHashCodeObject extends XObject {
    private String name;

    public void setName(String s)
    {
        this.name=s;
    }

    public String getName()
    {
        return this.name;
    }
    public static void main(String[] args){
        MyHashCodeObject my=new MyHashCodeObject();
        my.setName("abc");
        System.out.println("hashcode:"+my.hashCode());
        MyHashCodeObject object=(MyHashCodeObject)XObject.getObjectByRawHashCode(my.hashCode());
        MyHashCodeObject object1=(MyHashCodeObject)XObject.getObjectByRawHashCode(621009875);
        // 通过hashcode重新得到这个对象
        System.out.println(object1.getName());
    }

}
