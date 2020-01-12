package com.lsp.springbootmybatisdemo.test.设计模式.原型设计模式;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @FileName: Book
 * @Description:
 * @AuthOr: lsp
 * @Date: 2020/1/12 18:03
 */
@Slf4j
public class Book implements Cloneable{

    private String title;//书名
    private ArrayList<String> listImg = new ArrayList<>();//书中的图片

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<String> getListImg() {
        return listImg;
    }

    public void setListImg(ArrayList<String> listImg) {
        this.listImg = listImg;
    }

    public void addImg(String imgName){
        listImg.add(imgName);
    }

    public void showBookMessage() {
        System.out.println("........................start.......................");
        log.info("书名-" + this.title);
        for (String s : listImg) {
            log.info("图片-" + s);
        }
        System.out.println(".........................end.........................");
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //克隆分为浅克隆和深克隆  默认是浅克隆
        Book book = (Book) super.clone();
        // 添加这句升级为深克隆，让图片这个引用类型也可以克隆
        book.listImg = (ArrayList<String>) this.listImg.clone();
        return book;
    }
}
