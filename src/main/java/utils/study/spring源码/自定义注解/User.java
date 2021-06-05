package utils.study.spring源码.自定义注解;

import org.springframework.transaction.annotation.Transactional;

/**
 * @Author kula
 * @create 2021/5/11 下午11:19
 */

public class User {
    @AddAnnotation(userId = 2, userName = "zp")
    @Transactional
    public void add() {

    }
}
