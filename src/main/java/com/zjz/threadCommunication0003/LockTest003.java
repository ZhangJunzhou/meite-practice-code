package com.zjz.threadCommunication0003;

class Res111 {
    public String userSex;
    public String userName;
}


class IntThread111 extends Thread {
    private Res111 res;

    public IntThread111(Res111 res) {
        this.res = res;
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {


                if (count == 0) {
                    res.userName = "锦航";
                    res.userSex = "男";
                } else {
                    res.userName = "明珠";
                    res.userSex = "女";
                }
                count = (count + 1) % 2;

        }
    }
}

class OutThread111 extends Thread {
    private Res111 res;

    public OutThread111(Res111 res) {
        this.res = res;
    }

    @Override
    public void run() {
        while (true) {

            System.out.println(res.userName + "--" + res.userSex);

        }
    }
}

/**
 * @ClassName InputThread
 * @Author Junzhou Zhang
 * @Create 2022/8/22 23:05
 */
public class LockTest003 {
    public static void main(String[] args) {
        Res111 res = new Res111();
        IntThread111 intThread = new IntThread111(res);
        OutThread111 outThread = new OutThread111(res);
        intThread.start();
        outThread.start();
    }
}
