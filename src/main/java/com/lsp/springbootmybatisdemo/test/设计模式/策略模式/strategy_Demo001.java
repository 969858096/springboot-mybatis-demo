package com.lsp.springbootmybatisdemo.test.设计模式.策略模式;

/**
 * @FileName: strategy_Demo001
 * @Description:
 * @AuthOr: lsp
 * @Date: 2020/1/12 18:50
 */
public class strategy_Demo001 {

    public static void main(String[] args) {

    }

    public void getPrice(String level) throws Exception {
        Long price = null;
        switch (level) {
            case "普通会员":
                price = (long) (200 * 100);
                break;
            case "黄金会员":
                price = (long) (150 * 100);
                break;
            case "珀金会员":
                price = (long) (100 * 100);
                break;
            default:
                throw new Exception();
        }
    }
}
