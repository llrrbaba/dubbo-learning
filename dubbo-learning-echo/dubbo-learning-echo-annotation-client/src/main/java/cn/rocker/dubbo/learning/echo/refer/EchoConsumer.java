package cn.rocker.dubbo.learning.echo.refer;

import cn.rocker.dubbo.learning.echo.api.EchoService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

/**
 * @author rocker
 * @date 2019/11/17 16:32
 * @since V1.0
 */
@Component
public class EchoConsumer {

    @Reference
    private EchoService echoService;

    public String echo(String name) {
        return echoService.echo(name);
    }

}
