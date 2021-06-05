package utils.study.test_设计模式.代理.静态代理;

/**
 * @Author kula
 * @create 2021/5/9 下午4:44
 */
public class UserDaoProxy implements UserDao {
    private UserDao userDao;

    public UserDaoProxy(UserDao userDao) {
        this.userDao = userDao;
    }
    @Override
    public void add() {
        System.out.println("代理，执行add方法前");
        userDao.add();
        System.out.println("代理，执行add方法后");
    }
}
