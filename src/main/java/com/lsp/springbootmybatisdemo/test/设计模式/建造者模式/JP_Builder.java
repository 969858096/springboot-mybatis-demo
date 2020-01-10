package com.lsp.springbootmybatisdemo.test.设计模式.建造者模式;

import lombok.extern.slf4j.Slf4j;

/**
 * @FileName: ManBuilder
 * @Description: 建造日本人
 * @AuthOr: lsp
 * @Date: 2020/1/10 23:51
 */
@Slf4j
public class JP_Builder implements PersonBuilder {
    private Person person = new Person();

    @Override
    public void buildHead() {
      person.setHead("头部》》金发，大脸");
    }

    @Override
    public void buildBody() {
        person.setBody("体部》》高，壮");
    }

    @Override
    public void buildFoot() {
        person.setFoot("四肢》》腿长");
    }

    @Override
    public Person buildPerson() {
        return person;
    }
}
