package com.javademo.base.concurrent.state;

/**
 * @Author YSS
 * @Date 2020/6/12 16:01
 */
public class NewRunnableTerminated {
    public static void main(String[] args) throws InterruptedException {
        Runnable target=()->{
            for(int i=0;i<1000;i++){
                System.out.println(i);
                if(i==200){
                    System.out.println("运行时--->"+Thread.currentThread().getState());
                }
            }
        };
        Thread thread=new Thread(target);
        System.out.println("构造好Thread调用start()前--->"+thread.getState());
        thread.start();
        System.out.println("调用start()后--->"+thread.getState());
        Thread.sleep(5000);
        System.out.println("线程运行结束-->"+thread.getState());
    }
}
