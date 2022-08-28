package com.zjz.reflection0006;

/**
 * @ClassName UserEntity
 * @Author Junzhou Zhang
 * @Create 2022/8/28 15:56
 */
public class UserEntity {

    private String userId;
    private String userName;

    public UserEntity() {
        System.out.println("无参构造函数------通过反射机制创建实例化对象");
    }

    public UserEntity(String userId, String userName) {
        System.out.println("通过反射机制创建实例化对象");
        this.userId = userId;
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
