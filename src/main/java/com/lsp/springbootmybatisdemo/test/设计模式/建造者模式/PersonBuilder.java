package com.lsp.springbootmybatisdemo.test.设计模式.建造者模式;

/**
 * @FileName: PersonBuilder
 * @Description:
 * @AuthOr: lsp
 * @Date: 2020/1/10 23:47
 */
public interface PersonBuilder {

    void buildHead();
    void buildBody();
    void buildFoot();
    Person buildPerson();//组装人
}
