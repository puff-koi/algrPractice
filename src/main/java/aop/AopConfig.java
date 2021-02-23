package aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author: liziqiang
 * @description: AopConfig
 * @date: 2021/2/18 上午11:09
 */
@Configuration
@ComponentScan("aop")
@EnableAspectJAutoProxy
public class AopConfig {
}
