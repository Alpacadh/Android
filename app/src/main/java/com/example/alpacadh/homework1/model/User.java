package com.example.alpacadh.homework1.model;

/**
 * Created by Alpacadh on 2017/12/14.
 */

public class User {   private int id;
    public int getId(String name) {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    public String getPhonenumber(String phone){return phonenumber;}

    public void setPhonenumber(String phonenumber){this.phonenumber=phonenumber;}

    public String getsex(String sex){return this.sex;}

    public void setSex(String sex){this.sex=sex;}
    private String username;
    private String userpwd;
    private String phonenumber;
    private String sex;

}
