package com.javademo.base.concurrent.deadlock;

import java.util.Random;

/**
 * 所有线程死锁
 * @Author YSS
 * @Date 2020/6/14 22:13
 */
public class MultiAccountTransformMoney {
    private static int ACCOUNT_NUM=100;
    private static int TRANSFORM_NUM=1000000;
    private static int INITIAL_MONEY=1000000;
    private static int THREAD_NUM=20;
    public static void main(String[] args) {
        TransformMoney.Account[] accounts=new TransformMoney.Account[ACCOUNT_NUM];
        for (int i=0;i<ACCOUNT_NUM;i++){
            accounts[i]=new TransformMoney.Account(INITIAL_MONEY);
        }
        Random random=new Random();
        Runnable target=()->{
            for (int i=0;i<TRANSFORM_NUM;i++){
                int fromAccountId= random.nextInt(ACCOUNT_NUM-1);
                int toAccountId= random.nextInt(ACCOUNT_NUM-1);
                int money = random.nextInt(INITIAL_MONEY);
                TransformMoney.transformMoney(accounts[fromAccountId],accounts[toAccountId],money);
            }
        };
        for (int i=0;i<THREAD_NUM;i++){
            Thread thread=new Thread(target);
            thread.start();
        }
    }
}
