package com.zjz.threadCommunication0003;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Res {
    public String userSex;
    public String userName;

    public boolean writeDone = false;

    public Lock lock = new ReentrantLock();
    public Condition condition = lock.newCondition();
}


class IntThread extends Thread {
    private Res res;

    public IntThread(Res res) {
        this.res = res;
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {
            try {
                //获取锁
                res.lock.lock();
                if (res.writeDone) {
                    try {
                        res.condition.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (count == 0) {
                    res.userName = "锦航";
                    res.userSex = "男";
                } else {
                    res.userName = "明珠";
                    res.userSex = "女";
                }
                res.writeDone = true;
                count = (count + 1) % 2;
                res.condition.signalAll();
                // 释放锁
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                res.lock.unlock();
            }
        }
    }
}

class OutThread extends Thread {
    private Res res;

    public OutThread(Res res) {
        this.res = res;
    }

    @Override
    public void run() {
        while (true) {
            try {
                //获取锁
                res.lock.lock();
                if (!res.writeDone) {
                    try {
                        res.condition.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(res.userName + "--" + res.userSex);
                res.writeDone = false;
                res.condition.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {

                // 释放锁
                res.lock.unlock();
            }

        }
    }
}

/**
 * @ClassName InputThread
 * @Author Junzhou Zhang
 * @Create 2022/8/22 23:05
 */
public class ThreadCommunicationTest {
    public static void main(String[] args) {
        Res res = new Res();
        IntThread intThread = new IntThread(res);
        OutThread outThread = new OutThread(res);
        intThread.start();
        outThread.start();
    }
}
