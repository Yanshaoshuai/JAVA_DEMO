package com.javademo.base.concurrent.threadexception;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @Author YSS
 * @Date 2020/6/13 16:54
 */
public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    private String name;

    public MyUncaughtExceptionHandler(String name) {
        this.name = name;
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        Logger logger=Logger.getAnonymousLogger();
        logger.log(Level.WARNING,"线程"+t.getName()+"抛出异常",e);
        System.out.println("UncaughtExceptionHandler"+name+"捕获了异常");
    }
}
