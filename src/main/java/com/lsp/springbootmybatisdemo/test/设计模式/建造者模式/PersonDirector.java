package com.lsp.springbootmybatisdemo.test.设计模式.建造者模式;

/**
 * @FileName: PersonDirector
 * @Description: 整合部件  构建任务
 * @AuthOr: lsp
 * @Date: 2020/1/11 00:02
 */
public class PersonDirector {
    public Person buildingPerson(PersonBuilder personBuilder){
        //按顺序拼接
        personBuilder.buildHead();
        personBuilder.buildBody();
        personBuilder.buildFoot();
        return personBuilder.buildPerson();
    }

    public static void main(String[] args) {
        //组装美国人
        Person usPeople = new PersonDirector().buildingPerson(new US_Builder());
        System.out.println(usPeople);

        //组装日本人
        Person jpPeople = new PersonDirector().buildingPerson(new JP_Builder());
        System.out.println(jpPeople);
    }
}
