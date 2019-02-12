package com.thread.test;

public class HitPeopleRunnable implements Runnable {
    private int sumHit = 1000;
    @Override
    public void run() {
        while (true){
            //加锁
            Data.lock.lock();

            if (sumHit > 0){
                System.out.println(Thread.currentThread().getName() + "打了小明一拳");
                if (Thread.currentThread().getName().equals("张三")){
                    Data.zsHitNum++;
                } else if (Thread.currentThread().getName().equals("李四")){
                    Data.lsHitNum++;
                } else {
                    Data.wwHitNum++;
                }
                sumHit -= 1;
            } else {
                System.out.println("小明被打死了");
                System.out.println("张三：" + Data.zsHitNum + "拳");
                System.out.println("李四：" + Data.lsHitNum + "拳");
                System.out.println("王五：" + Data.wwHitNum + "拳");
                System.out.println("一共：" + (Data.zsHitNum + Data.lsHitNum + Data.wwHitNum) + "拳");
                //防止数据刷的过快 休眠一段时间
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            Data.lock.unlock();
        }
    }
}
