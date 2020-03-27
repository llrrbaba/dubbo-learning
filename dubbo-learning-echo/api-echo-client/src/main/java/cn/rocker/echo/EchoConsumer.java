package cn.rocker.echo;

import cn.rocker.dubbo.learning.echo.api.EchoService;
import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;

/**
 * @author rocker
 * @date 2020/03/27 15:26
 * @since V1.0
 */
public class EchoConsumer {

    public static void main(String[] args) {
        ReferenceConfig<EchoService> referenceConfig = new ReferenceConfig<>();
        referenceConfig.setApplication(new ApplicationConfig("java-echo-consumer"));
        referenceConfig.setRegistry(new RegistryConfig("zookeeper://192.168.60.133:2181"));
        referenceConfig.setInterface(EchoService.class);
        EchoService echoService = referenceConfig.get();
        String message = echoService.echo("Hello World");
        System.out.println(message);
    }

}
