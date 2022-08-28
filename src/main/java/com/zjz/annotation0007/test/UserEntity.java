package com.zjz.annotation0007.test;

/**
 * @ClassName UserEntity
 * @Author Junzhou Zhang
 * @Create 2022/8/28 20:20
 */
@SetTable("user_table")
public class UserEntity {
    @SetProperty(name = "user_name", length = 10)
    private String userName;

    @SetProperty(name = "user_age", length = 10)
    private Integer userAge;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }
}
