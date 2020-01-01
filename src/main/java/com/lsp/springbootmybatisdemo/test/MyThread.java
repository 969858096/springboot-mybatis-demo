package com.lsp.springbootmybatisdemo.test;

/**
 * @program: springboot-mybatis-demo
 * @description:
 * @author: lsp
 * @create: 2019-12-30 17:59
 * @version:1.0
 **/
public class MyThread {
    public static void main(String[] args) {
        Bank bank = new Bank(1000);
        Thread threadSave = new Thread(new SaveMoney(bank));
        Thread threadGet = new Thread(new GetMoney(bank));
        threadSave.start();
        threadGet.start();

    }
}

class Bank {
    private int money;

    public Bank(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}

class SaveMoney implements Runnable {
    private volatile Bank bank;

    public SaveMoney(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
       while (bank.getMoney() < 2000){
           save(bank);
           try {
               Thread.currentThread().sleep(500);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           System.out.println("存钱100块成功，余额=" + bank.getMoney());
       }
    }

    public synchronized void save(Bank bank) {
        this.bank = bank;
        int money = bank.getMoney();
        money = money + 100;
        bank.setMoney(money);
    }
}

class GetMoney implements Runnable {
    private Bank bank;

    public GetMoney(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
       while (bank.getMoney()>0){
           get(bank);
           try {
               Thread.currentThread().sleep(500);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           System.out.println("取钱200块成功，余额=" + bank.getMoney());
       }
    }

    public synchronized Integer get(Bank bank) {
        this.bank = bank;
        int money = bank.getMoney();
        money = money - 100;
        bank.setMoney(money);
        return money;
    }
}
