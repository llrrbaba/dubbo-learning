package cn.rocker.dubbo.learning.echo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author: chengzc
 * @create: 2019-11-17 10:27
 * @since:
 **/
public class EchoProvider {

    public static void main(String[] args) throws IOException {
        // 1 指定服务暴露配置文件
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/echo-provider.xml");

        // 2 启动spring容器，并暴露服务
        context.start();

        System.in.read();
    }
}
