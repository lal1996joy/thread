package com.thread.test;

public class ThreadTestDemo {
    public static void main(String[] args) {
        /**
         * 线程数据安全问题出现条件：
         *
         * （1）多线程环境
         * （2）多个线程操作共享数据
         * （3）每一个线程共享数据的语句有多条
         *
         * 解决方法：
         * （1）同步代码块
         * （2）同步方法
         * （3）Lock对象锁
         */

        /**
         * 抢钱案例
         */
//        MoneyRunnable mr = new MoneyRunnable();  //抢钱
//        HitPeopleRunnable hpr = new HitPeopleRunnable();  //打小明
        TicketRunnable tr = new TicketRunnable();  //卖票
        Thread thread1 = new Thread(tr);
        Thread thread2 = new Thread(tr);
        Thread thread3 = new Thread(tr);
          thread1.setName("张三");
          thread2.setName("李四");
          thread3.setName("王五");
        thread1.start();
        thread2.start();
        thread3.start();

    }
}
