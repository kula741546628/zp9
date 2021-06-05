package utils.study.spring源码.自定义注解;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author kula
 * @create 2021/5/11 下午11:19
 */
@Target(value = ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AddAnnotation {

    int userId() default 0;

    String userName() default "默认名称";

}
