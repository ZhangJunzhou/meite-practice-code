package com.zjz.threadCommunication0003;


class Res1 {
    public String userSex;
    public String userName;
    //线程通讯标识
    public boolean writeDone = false;
}

class IntThrad extends Thread {
    private Res1 res;
    public IntThrad(Res1 res) {
        this.res = res;
    }
    @Override
    public void run() {
        int count = 0;
        while (true) {
            synchronized (res) {
                if (res.writeDone) {
                    try {
                        // 当前线程变为等待，但是可以释放锁
                        res.wait();
                    } catch (Exception e) {

                    }
                }
                if (count == 0) {
                    res.userName = "余胜军";
                    res.userSex = "男";
                } else {
                    res.userName = "小紅";
                    res.userSex = "女";
                }
                count = (count + 1) % 2;
                res.writeDone = true;
                // 唤醒当前线程
                res.notifyAll();
            }

        }
    }
}

class OutThread1 extends Thread {
    private Res1 res;
    public OutThread1(Res1 res) {
        this.res = res;
    }
    @Override
    public void run() {
        while (true) {
            synchronized (res) {
                if (!res.writeDone) {
                    try {
                        res.wait();
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                }
                System.out.println(res.userName + "--" + res.userSex);
                res.writeDone = false;
                res.notifyAll();
            }
        }
    }
}


/**
 * @ClassName ThreaCommun
 * @Author Junzhou Zhang
 * @Create 2022/8/22 23:22
 */
public class ThreaCommun {
    public static void main(String[] args) {
        Res1 res = new Res1();
        IntThrad intThrad = new IntThrad(res);
        OutThread1 outThread = new OutThread1(res);
        intThrad.start();
        outThread.start();
    }
}
