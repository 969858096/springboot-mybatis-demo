package com.lsp.springbootmybatisdemo.test.设计模式.建造者模式;

/**
 * @FileName: Person
 * @Description:
 * @AuthOr: lsp
 * @Date: 2020/1/10 23:44
 */
public class Person {
    private String head;//头
    private String body;//体部
    private String foot;//四肢

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getFoot() {
        return foot;
    }

    public void setFoot(String foot) {
        this.foot = foot;
    }

    @Override
    public String toString() {
        return "Person{" +
                "head='" + head + '\'' +
                ", body='" + body + '\'' +
                ", foot='" + foot + '\'' +
                '}';
    }
}
