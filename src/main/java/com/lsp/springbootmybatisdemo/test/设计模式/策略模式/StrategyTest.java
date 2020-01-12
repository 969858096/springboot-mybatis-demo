package com.lsp.springbootmybatisdemo.test.设计模式.策略模式;

/**
 * @FileName: Strategy
 * @Description:
 * @AuthOr: lsp
 * @Date: 2020/1/12 19:02
 */
abstract class Strategy {
    public abstract void algorithmInterface();
}

//普通会员算法
class StrategyA extends Strategy{

    @Override
    public void algorithmInterface() {
        System.out.println("普通会员算法");
    }
}

//黄金会员算法
class StrategyB extends Strategy{

    @Override
    public void algorithmInterface() {
        System.out.println("黄金会员算法");
    }
}

//铂金会员算法
class StrategyC extends Strategy{

    @Override
    public void algorithmInterface() {
        System.out.println("铂金会员算法");
    }
}

//算法包装
class Context{//再包装一层  隐藏算法
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void algorithmInterface(){
        strategy.algorithmInterface();
    }
}

//测试
public class StrategyTest{
    public static void main(String[] args) {
        Strategy strategyA = new StrategyA();
        Context contextA = new Context(strategyA);
        contextA.algorithmInterface();

        Strategy strategyB = new StrategyB();
        Context contextB = new Context(strategyB);
        contextB.algorithmInterface();

        Strategy strategyC = new StrategyC();
        Context contextC = new Context(strategyC);
        contextC.algorithmInterface();
    }
}
