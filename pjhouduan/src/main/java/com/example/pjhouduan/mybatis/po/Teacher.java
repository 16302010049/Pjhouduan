package com.example.pjhouduan.mybatis.po;

public class Teacher {
    private int id;
    private String name;
    private String password;
    private String head;

    public Teacher(int id,String name,String password,String head){
       this.id = id;
       this.name = name;
       this.password = password;
       this.head = head;
    }

    public Teacher(String name,String password,String head){
        this.name = name;
        this.password = password;
        this.head = head;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String passsword) {
        this.password = passsword;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }
}
