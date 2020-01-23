package com.qfzz.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

//给前端说明这是什么类
@ApiModel("用户")
public class User {

    /**
     * @ApiModelProperty从字面上理解就是告诉前端，这属性是什么意思
     * 英文单词是：Api模型属性
     */
    @ApiModelProperty("ID")
    private String uid;
    @ApiModelProperty("账号")
    private String username;
    @ApiModelProperty("密码")
    private String password;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
