package com.zjz.threadDemo0001;

import com.zjz.threadDemo0001.entity.UserEntity;
import com.zjz.threadDemo0001.thread.UserThread;
import com.zjz.threadDemo0001.utils.ListUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CoreCode
 * @Author Junzhou Zhang
 * @Create 2022/8/13 20:00
 */
public class CoreCode {
    public static void main(String[] args) {
        // 1、初始化数据
        List<UserEntity> userEntities = initUser();
        // 2、定义每个线程最多跑多少数据
        int userPerThread= 2;
        // 3、计算线程数，并计算每个线程跑哪些数据
        List<List<UserEntity>> lists = ListUtils.splitList(userEntities, userPerThread);
        for(int i = 0; i < lists.size(); i++){
            List<UserEntity> userEntities1 = lists.get(i);
//            System.out.println("i:  " + i + " " + userEntities1.toString());
            // 4、子线程分批异步处理数据
            new UserThread(userEntities1).start();
        }

    }

    public static List<UserEntity> initUser(){
        ArrayList<UserEntity> userEntities = new ArrayList<>();
        for(int i = 0; i < 11; i++){
            userEntities.add(new UserEntity("userId: " + i, "userName： " + i));
        }
        return userEntities;
    }

}
