package com.lsp.springbootmybatisdemo.test.设计模式.工厂方法模式;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

/**
 * @FileName: BYDFactory
 * @Description:
 * @AuthOr: lsp
 * @Date: 2020/1/10 21:07
 */
@Slf4j
public class BYDFactory implements CarFactory {
    @Override
    public Car makeCar(String carName) {
        Car car = null;
        if (StringUtils.isNotBlank(carName)){
            if (carName.equals("比亚迪")){
                car = new BYD();
            }else {
                log.info("车不存在");
            }
        }else {
            log.info("carName must not be null or null String");
        }
        return car;
    }
}
