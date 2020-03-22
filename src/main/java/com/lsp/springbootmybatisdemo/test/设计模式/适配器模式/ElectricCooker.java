package com.lsp.springbootmybatisdemo.test.设计模式.适配器模式;

import lombok.extern.slf4j.Slf4j;

/**
 * @FileName: ElectricCooker
 * @Description: 电饭煲
 * @AuthOr: lsp
 * @Date: 2020/1/12 14:10
 */
//电饭煲以及代码测试
@Slf4j
public class ElectricCooker {

    private JP110V_interface jp110V_interface;

    public ElectricCooker(JP110V_interface jp110V_interface) {
        this.jp110V_interface = jp110V_interface;
    }

    public void cook() {
       JP110V_interface jp110V_interface = new PowerAdaptor(new CN220V_interfaceImpl());//使用电源适配器，把110v的电源转为220v的电源  电饭锅姐可以开始工作了
       jp110V_interface.connect();
        log.info("电饭煲开始煮饭---");
    }


    public static void main(String[] args) {
        new ElectricCooker(new JP110V_interfaceImpl()).cook();
    }
}
