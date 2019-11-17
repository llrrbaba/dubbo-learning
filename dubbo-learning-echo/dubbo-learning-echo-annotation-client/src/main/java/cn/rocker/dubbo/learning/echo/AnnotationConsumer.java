package cn.rocker.dubbo.learning.echo;

import cn.rocker.dubbo.learning.echo.refer.EchoConsumer;
import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ConsumerConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author rocker
 * @date 2019/11/17 16:34
 * @since V1.0
 */
public class AnnotationConsumer {

    public static void main(String[] args) {
        // #1 基于注解配置初始化spring上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
        context.start();
        // #2 发起服务调用
        EchoConsumer echoService = context.getBean(EchoConsumer.class);
        String hello = echoService.echo("Hello world!");
        System.out.println("result: " + hello);
    }

    @Configuration
    // #3 指定要扫描的消费注解，会触发注入
    @EnableDubbo(scanBasePackages = "cn.rocker.dubbo.learning.echo")
    @ComponentScan(value = {"cn.rocker.dubbo.learning.echo"})
    // TODO czc 这里为啥同时有@EnableDubbo和@ComponentScan
    static class ConsumerConfiguration {
        @Bean
        public ApplicationConfig applicationConfig() {
            ApplicationConfig applicationConfig = new ApplicationConfig();
            applicationConfig.setName("echo-annotation-consumer");
            return applicationConfig;
        }

        @Bean
        public ConsumerConfig consumerConfig() {
            return new ConsumerConfig();
        }

        @Bean
        public RegistryConfig registryConfig() {
            RegistryConfig registryConfig = new RegistryConfig();
            // #4 使用zookeeper作为注册中心，同时给出注册中心ip和端口
            registryConfig.setProtocol("zookeeper");
            registryConfig.setAddress("192.168.60.131");
            registryConfig.setPort(2181);
            return registryConfig;
        }
    }

}
