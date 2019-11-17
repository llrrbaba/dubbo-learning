package cn.rocker.dubbo.learning.echo.impl;

import cn.rocker.dubbo.learning.echo.api.EchoService;
import com.alibaba.dubbo.rpc.RpcContext;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: chengzc
 * @create: 2019-11-17 10:06
 * @since:
 **/
public class EchoServiceImpl implements EchoService {

    public String echo(String message) {
        String now = new SimpleDateFormat("HH:mm:ss").format(new Date());
        System.out.println("[" + now + "] Hello " + message
                + ", request from consumer: " + RpcContext.getContext().getRemoteAddress());
        return message;
    }

}
