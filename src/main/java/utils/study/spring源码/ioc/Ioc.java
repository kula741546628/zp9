package utils.study.spring源码.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author kula
 * @create 2021/5/15 下午10:02
 */
public class Ioc {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("spring.xml");
        System.out.println("##################");
        User user = (User) app.getBean("user");
        System.out.println(user);
    }
}
