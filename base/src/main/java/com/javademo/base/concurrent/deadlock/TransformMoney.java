package com.javademo.base.concurrent.deadlock;

import java.util.concurrent.TimeUnit;

/**
 * @Author YSS
 * @Date 2020/6/14 21:50
 */
public class TransformMoney{
    public static void main(String[] args) throws InterruptedException {
        Account a=new Account(500);
        Account b=new Account(500);
        Thread a2b=new Thread(()->{
            transformMoney(a,b,200);
        });
        Thread b2a=new Thread(()->{
            transformMoney(b,a,100);
        });
        a2b.start();
        b2a.start();
        a2b.join();
        b2a.join();
        System.out.println("a余额为"+a.balance+",b余额为"+b.balance);
    }
    public static void transformMoney(Account from,Account to,int money){
        synchronized (from){
            //睡眠为了产生死锁
           /* try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            synchronized (to){
                if(from.balance<money){
                    System.out.println("余额不足");
                }
                from.balance-=money;
                to.balance+=money;
                System.out.println("转账成功"+money+"元");
            }
        }
    }
    static class Account{
        int balance;
        public Account(int balance) {
            this.balance = balance;
        }
    }
}
