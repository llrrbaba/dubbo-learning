package cn.rocker.spi.dubbo;

import com.alibaba.dubbo.common.extension.SPI;

/**
 * @author rocker
 * @date 2020/03/27 22:02
 * @since V1.0
 */
@SPI("impl")
public interface SPIDemoService {

    void helloSPI();

}
