package cn.rocker.dubbo.learning.echo.impl;

import cn.rocker.dubbo.learning.echo.api.EchoService;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.RpcContext;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author rocker
 * @date 2019/11/17 16:17
 * @since V1.0
 */
@Service
public class EchoServiceImpl implements EchoService {

    public String echo(String message) {
        String now = new SimpleDateFormat("HH:mm:ss").format(new Date());
        System.out.println("[" + now + "] Hello " + message
                + ", request from consumer: " + RpcContext.getContext().getRemoteAddress());
        return message;
    }

}
