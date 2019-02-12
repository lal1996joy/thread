package com.thread.test;

/**
 * @author lal
 * @date 2019-2-12
 */
public class MoneyRunnable implements Runnable {
    private int sumMoney = 1000;
    @Override
    public void run() {

        while (true){
            /**
             * 同步代码块实现数据安全：
             *
             * 这里面的this就是一把锁，使用这个类创建的线程使用同一把锁
             */
            synchronized (this) {
                if (sumMoney > 0) {
                    /**
                     * sumMoney  -= 1; 放在前面没有问题
                     */
//                sumMoney  -= 1;

                    System.out.println(Thread.currentThread().getName() + "获得一元钱");
                    if (Thread.currentThread().getName().equals("张三")) {
                        Data.zsMoney++;
                    } else if (Thread.currentThread().getName().equals("李四")) {
                        Data.lsMoney++;
                    } else {
                        Data.wwMoney++;
                    }

                    /**
                     * sumHit = sumHit - 1; 放在后面就会出现数据安全问题（线程安全问题）
                     */
                    sumMoney -= 1;
                    /**
                     * sumMoney = sumMoney - 1
                     * 不是一个原子性的操作，所以很可能在执行了，sumMoney-1之后，赋值操作之前，另个线程进来了，所以，就会多执行一次抢钱动作，
                     * 所以，你也可以开n个线程，最多他们可以抢到(1000+n-1)元，当然n<=1000;
                     */
                } else {
                    System.out.println("钱抢完了");
                    System.out.println("张三：" + Data.zsMoney);
                    System.out.println("李四：" + Data.lsMoney);
                    System.out.println("王五：" + Data.wwMoney);
                    System.out.println("共：" + (Data.zsMoney + Data.lsMoney + Data.wwMoney));

                    //防止数据刷的过快，休眠一段时间
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }
}
