package com.lsp.springbootmybatisdemo.test.设计模式.建造者模式;

import lombok.extern.slf4j.Slf4j;

/**
 * @FileName: ManBuilder
 * @Description: 建造美国人
 * @AuthOr: lsp
 * @Date: 2020/1/10 23:51
 */
@Slf4j
public class US_Builder implements PersonBuilder {

    private Person person = new Person();
    @Override
    public void buildHead() {
      person.setHead("头部》》黑发，小脸");
    }

    @Override
    public void buildBody() {
        person.setBody("体部》》矮，瘦小");
    }

    @Override
    public void buildFoot() {
        person.setFoot("四肢》》小短腿");
    }

    //拼装
    public Person buildPerson(){
        return person;
    }
}
