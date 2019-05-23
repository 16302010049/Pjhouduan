package com.example.pjhouduan.request;

import org.springframework.web.multipart.MultipartFile;

public class TeacherRegisterRequest {
    private String name;
    private String password;
    private MultipartFile head;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public MultipartFile getHead() {
        return head;
    }

    public void setHead(MultipartFile head) {
        this.head = head;
    }
}
