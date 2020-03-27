package cn.rocker.spi.dubbo;

import com.alibaba.dubbo.common.extension.ExtensionLoader;

/**
 * @author rocker
 * @date 2020/03/27 22:03
 * @since V1.0
 */
public class SPIDemoServiceImpl implements SPIDemoService {

    public void helloSPI() {
        System.out.println("hello spi");
    }


    public static void main(String[] args) {
        SPIDemoService defaultExtension = ExtensionLoader
                .getExtensionLoader(SPIDemoService.class)
                .getDefaultExtension();

        defaultExtension.helloSPI();
    }
}
