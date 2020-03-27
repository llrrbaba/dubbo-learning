package cn.rocker.spi.jdk;

import java.util.ServiceLoader;

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
        ServiceLoader<SPIDemoService> spiDemoServices = ServiceLoader.load(SPIDemoService.class);
        for (SPIDemoService spiDemoService : spiDemoServices) {
            spiDemoService.helloSPI();
        }
    }
}
