package com.thread.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lal
 * @date 2019-2-12
 */
public class Data {
    //抢钱1000 ，解决：同步代码块
    public static int zsMoney = 0;
    public static int lsMoney = 0;
    public static int wwMoney = 0;

    //打小明 ，解决：Lock对象锁
    public static int zsHitNum = 0;
    public static int lsHitNum = 0;
    public static int wwHitNum = 0;

    public static Object lockObject1 = new Data();
    public static Object lockObject2 = new Data();

    public static Lock lock = new ReentrantLock();
}
