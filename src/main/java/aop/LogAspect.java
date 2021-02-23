package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author: liziqiang
 * @description: LogAspect
 * @date: 2021/2/18 上午10:51
 */
@Aspect
@Component
public class LogAspect {
    @Pointcut("@annotation(aop.MyActionAop)")
    public void annoationPointCut(){};

    @Before("annoationPointCut()")
    public void annoationBefore(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        MyActionAop myActionAop = method.getAnnotation(MyActionAop.class);
        System.out.println("before方法 + 注解：" + myActionAop.aopName());
    }

    @After("annoationPointCut()")
    public void annoationAfter(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        MyActionAop myActionAop = method.getAnnotation(MyActionAop.class);
        System.out.println("after方法 + 注解：" + myActionAop.aopName());
    }

    @Before("execution(* aop.DemoMethodService.*(..))")
    public void methodBefore(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("before拦截method的service"+method.getName());
    }

    @After("execution(* aop.DemoMethodService.*(..))")
    public void methodAfter(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("after拦截method的service"+method.getName());
    }



}
