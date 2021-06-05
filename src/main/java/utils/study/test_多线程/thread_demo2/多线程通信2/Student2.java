package utils.study.test_多线程.thread_demo2.多线程通信2;

/**
 * @Author kula
 * @create 2021/4/30 下午7:46
 */
public class Student2 {
    public ThreadLocal<String> name = new ThreadLocal<String>(){
        @Override
        protected String initialValue() {
            return "";
        }
    };

    public ThreadLocal<String> sex = new ThreadLocal<String>(){
        @Override
        protected String initialValue() {
            return "";
        }
    };

    public void setName(String name){
        this.name.set(name);
    }
    public void setSex(String sex){
        this.sex.set(sex);
    }

    public String getName(){
        return name.get();
    }

    public String getSex(){
        return sex.get();
    }

//    public String name;

//    public String sex;
}
