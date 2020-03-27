package cn.rocker.echo;

import cn.rocker.dubbo.learning.echo.api.EchoService;
import cn.rocker.echo.impl.EchoServiceImpl;
import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;

import java.io.IOException;

/**
 * @author rocker
 * @date 2020/03/27 15:15
 * @since V1.0
 */
public class EchoProvider {

    public static void main(String[] args) throws IOException {
        ServiceConfig<EchoService> serviceConfig = new ServiceConfig<>();
        serviceConfig.setApplication(new ApplicationConfig("java-echo-provider"));
        serviceConfig.setRegistry(new RegistryConfig("zookeeper://192.168.60.133:2181"));
        serviceConfig.setInterface(EchoService.class);
        serviceConfig.setRef(new EchoServiceImpl());
        serviceConfig.export();
        System.out.println("java-echo-provider is running");
        System.in.read();
    }

}
