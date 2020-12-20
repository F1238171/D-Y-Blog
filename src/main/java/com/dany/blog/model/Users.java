package com.dany.blog.model;

public class Users {
    private Long userid;

    private String username;

    private String account;

    private String password;

    private String baseinfo;

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getBaseinfo() {
        return baseinfo;
    }

    public void setBaseinfo(String baseinfo) {
        this.baseinfo = baseinfo == null ? null : baseinfo.trim();
    }
}