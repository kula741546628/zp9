package utils.study.test_设计模式.代理.静态代理;

/**
 * @Author kula
 * @create 2021/5/9 下午4:44
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("执行add");
    }
}
