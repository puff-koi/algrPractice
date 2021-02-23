package aop;

import org.springframework.stereotype.Service;

/**
 * @author: liziqiang
 * @description: DemoAnnotationService
 * @date: 2021/2/18 上午10:55
 */
@Service
public class DemoAnnotationService {
    @MyActionAop(aopName = "注解方式拦截了")
    public void add(){}
}
