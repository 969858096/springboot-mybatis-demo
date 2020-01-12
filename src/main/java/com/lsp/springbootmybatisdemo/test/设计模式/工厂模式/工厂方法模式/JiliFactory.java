package com.lsp.springbootmybatisdemo.test.设计模式.工厂模式.工厂方法模式;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
//吉利厂家
@Slf4j
public class JiliFactory implements CarFactory  {
    @Override
    public Car makeCar(String carName) {
        Car car = null;
        if (StringUtils.isNotBlank(carName)){
            if (carName.equals("吉利")){
                car = new JiLiCar();
            }else {
                log.info("车不存在");
            }
        }else {
            log.info("carName must not be null or null String");
        }
        return car;
    }
}
