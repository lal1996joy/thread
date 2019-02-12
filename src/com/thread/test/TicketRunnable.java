package com.thread.test;

/**
 * 卖票
 */
public class TicketRunnable implements Runnable {
    private int number = 1000;
    private int count = 0;
    @Override
    public void run() {
        while (true){
            sysoInfo();

        }
    }

    /**
     *同步方法实现，关键字synchronized也可以放在权限修饰符前面
     */
    private synchronized void sysoInfo(){
        if (number > 0){
            System.out.println("当前卖了" + (++count) + "张票");
            System.out.println(Thread.currentThread().getName() + "出售了第：" + count + "张票");
            number -= 1;
            System.out.println("还剩" + number + "张票");
        }
    }
}
