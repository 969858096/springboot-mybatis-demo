package com.lsp.springbootmybatisdemo.test.设计模式.模板方法模式;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @FileName: HttpServlet_TemplateMethod
 * @Description: 这里doGet doPost 方法使用到了模板方法设计模式
 * @AuthOr: lsp
 * @Date: 2020/1/11 23:52
 */
public class HttpServlet_TemplateMethod extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
