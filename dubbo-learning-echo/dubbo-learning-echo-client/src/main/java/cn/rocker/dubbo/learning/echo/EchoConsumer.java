package cn.rocker.dubbo.learning.echo;

import cn.rocker.dubbo.learning.echo.api.EchoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author rocker
 * @date 2019/11/17 15:56
 * @since V1.0
 */
public class EchoConsumer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/echo-consumer.xml"});
        context.start();
        EchoService echoService = (EchoService) context.getBean("echoService"); // get remote service proxy

        String status = echoService.echo("Hello world!");
        System.out.println("echo result: " + status);
    }

}
