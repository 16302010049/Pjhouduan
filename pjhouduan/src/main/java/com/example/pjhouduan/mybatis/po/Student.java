package com.example.pjhouduan.mybatis.po;

public class Student {
    private String id;
    private String signature;
    private String mailbox;
    private String sex;
    private String name;
    private String studentnumber;
    public Student(String id, String signature, String mailbox, String sex, String name, String studentnumber){
        this.id=id;
        this.signature=signature;
        this.mailbox=mailbox;
        this.sex=sex;
        this.name=name;
        this.studentnumber=studentnumber;

    }
     public Student(){

    }
//    public Student(int id,String signature){
//        this.id=id;
//        this.signature=signature;
//    }

    public String getId() {
        return id;
    }

    public String getMailbox() {
        return mailbox;
    }

    public String getSignature() {
        return signature;
    }

    public String getSex() {
        return sex;
    }

    public String getName() {
        return name;
    }

    public String getStudentnumber() {
        return studentnumber;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setStudentnumber(String studentnumber) {
        this.studentnumber = studentnumber;
    }
}
