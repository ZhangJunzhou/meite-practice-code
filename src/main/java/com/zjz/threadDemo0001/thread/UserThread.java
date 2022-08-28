package com.zjz.threadDemo0001.thread;

import com.zjz.threadDemo0001.entity.UserEntity;

import java.util.List;

/**
 * @ClassName UserThread
 * @Author Junzhou Zhang
 * @Create 2022/8/13 20:21
 */
public class UserThread extends Thread{
    private List<UserEntity> userEntities;

    public UserThread(List<UserEntity> userEntities){
        this.userEntities = userEntities;
    }

    @Override
    public void run() {
        for(int i = 0; i < userEntities.size(); i++){
            String userName = userEntities.get(i).getUserName();
            String userId = userEntities.get(i).getUserId();
            System.out.println(Thread.currentThread().getName() + "------" + "userName: " + userName + " ; userId: " + userId + " ---已发送信息！");
            try{
                Thread.sleep(1000);
            }
            catch (Exception e){
                System.out.println(e.getStackTrace());
            }
        }
    }
}
