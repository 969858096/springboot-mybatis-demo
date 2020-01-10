package com.lsp.springbootmybatisdemo.test.设计模式.简单工厂模式;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

/**
 * @FileName: CarFactory
 * @Description: 汽车厂（4S店），什么车都卖
 * @AuthOr: lsp
 * @Date: 2020/1/10 20:35
 */
@Slf4j
public class CarFactory {

    public static Car makeCar(String carName) {
        Car car = null;
        if (StringUtils.isNotBlank(carName)) {
            if (carName.equals("比亚迪")){
                car = new BYD();
            }else if (carName.equals("吉利")){
                car = new JiLiCar();
            }else {
                log.info("您所选择的车不存在！请重新选择");
            }
        } else {
            log.info("carName must not be null or null String");
        }
        return car;
    }

}
