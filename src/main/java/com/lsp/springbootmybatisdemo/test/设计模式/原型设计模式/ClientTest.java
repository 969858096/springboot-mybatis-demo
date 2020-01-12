package com.lsp.springbootmybatisdemo.test.设计模式.原型设计模式;

import lombok.extern.slf4j.Slf4j;

/**
 * @FileName: ClientTest
 * @Description:
 * @AuthOr: lsp
 * @Date: 2020/1/12 18:09
 */
@Slf4j
public class ClientTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Book book = new Book();
        book.setTitle("语文书");
        book.addImg("语文书图片");
        book.showBookMessage();


        Book book2 = (Book) book.clone();
        book2.setTitle("数学书");
        book2.addImg("数学书图片");
        book2.showBookMessage();


        System.out.println(book.getListImg());
        System.out.println(book2.getListImg());
    }
}
