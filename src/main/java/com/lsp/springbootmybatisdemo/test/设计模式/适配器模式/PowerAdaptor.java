package com.lsp.springbootmybatisdemo.test.设计模式.适配器模式;

/**
 * @FileName: PowerASdaptor
 * @Description: 电源适配器
 * @AuthOr: lsp
 * @Date: 2020/1/12 14:14
 */
public class PowerAdaptor implements JP110V_interface {

    private CN220V_interface cn220V_interface;

    public PowerAdaptor(CN220V_interface cn220V_interface) {
        this.cn220V_interface = cn220V_interface;
    }

    @Override
    public void connect() {//相当于在这个适配器里边把110V的电源转换为电饭煲能使用的220V电源
        cn220V_interface.connect();
    }
}
