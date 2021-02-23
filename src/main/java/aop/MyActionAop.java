package aop;

import java.lang.annotation.*;

/**
 * @author: liziqiang
 * @description: MyActionAop
 * @date: 2021/2/18 上午10:53
 * 这是一个自定义注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyActionAop {
    /**
     *这是要填的属性
     */
    String aopName();
}
