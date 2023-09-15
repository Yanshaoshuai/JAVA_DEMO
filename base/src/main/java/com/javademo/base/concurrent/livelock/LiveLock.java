package com.javademo.base.concurrent.livelock;

import java.util.concurrent.TimeUnit;

/**
 * 相互谦让 对方需要资源就让出自己的资源 -->导致都不会执行后续代码
 * @Author YSS
 * @Date 2020/6/15 14:08
 */
public class LiveLock {
    static class Spoon{
        private Diner owner;

        public Diner getOwner() {
            return owner;
        }

        public void setOwner(Diner owner) {
            this.owner = owner;
        }

        public Spoon(Diner owner) {
            this.owner = owner;
        }

        public synchronized void use(){
            System.out.printf("%s has eaten",owner.name);
        }
    }
    static class Diner{
        private String name;
        private boolean isHungry;

        public Diner(String name) {
            this.name = name;
            isHungry=true;
        }
        public void eatWith(Spoon spoon,Diner spouse){
            while (isHungry){
                if(spoon.owner!=this){
                    try {
                        TimeUnit.NANOSECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    continue;
                }
                if(spouse.isHungry){
                    System.out.println(name+":亲爱的"+spouse.name+"你先吃吧");
                    spoon.setOwner(spouse);
                    continue;
                }
                spoon.use();
                isHungry=false;
                System.out.println(name+":我吃完了");
                spoon.setOwner(spouse);
            }
        }
    }

    public static void main(String[] args) {
        Diner husband=new Diner("牛郎");
        Diner wife=new Diner("织女");
        Spoon spoon=new Spoon(husband);
        Thread husbandThread=new Thread(()->{
            husband.eatWith(spoon,wife);
        }); Thread wifeThread=new Thread(()->{
            wife.eatWith(spoon,husband);
        });

        husbandThread.start();
        wifeThread.start();
    }
}
