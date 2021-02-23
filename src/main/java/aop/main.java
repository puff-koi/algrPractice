package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: liziqiang
 * @description: algr.main
 * @date: 2021/2/18 上午11:10
 */
public class main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AopConfig.class);

        DemoAnnotationService demoAnnotationService =
                context.getBean(DemoAnnotationService.class);

        DemoMethodService demoMethodService =
                context.getBean(DemoMethodService.class);

        demoAnnotationService.add();

        demoMethodService.add();

        context.close();
    }
}
