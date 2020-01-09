package com.lsp.springbootmybatisdemo.test.设计模式.单列模式;

public enum EnumHttp {
    Http_200(200,"请求成功")/*,Http_500(500,"请求失败！！！")*/;

    private Integer httpCode;
    private String httpMsg;

    EnumHttp(Integer httpCode, String httpMsg) {
        System.out.println("枚举初始化");
        this.httpCode = httpCode;
        this.httpMsg = httpMsg;
    }

    public Integer getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(Integer httpCode) {
        this.httpCode = httpCode;
    }

    public String getHttpMsg() {
        return httpMsg;
    }

    public void setHttpMsg(String httpMsg) {
        this.httpMsg = httpMsg;
    }

    public static void main(String[] args) {
        System.out.println(EnumHttp.Http_200.httpCode);
        System.out.println(EnumHttp.Http_200.httpMsg);
    }
}
