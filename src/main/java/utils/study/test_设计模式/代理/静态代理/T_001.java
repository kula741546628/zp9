package utils.study.test_设计模式.代理.静态代理;

/**
 * @Author kula
 * @create 2021/5/9 下午4:46
 */
public class T_001 {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        UserDaoProxy proxy = new UserDaoProxy(userDao);
        proxy.add();
    }
}
