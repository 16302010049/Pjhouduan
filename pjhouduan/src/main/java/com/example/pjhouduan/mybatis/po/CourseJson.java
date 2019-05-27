package com.example.pjhouduan.mybatis.po;

public class CourseJson {
    private int id;
    private int teacher_id;
    private String title;
    private String subtitle;
    private String background;
    private String introduce;
    private String content;

    public CourseJson(int id, int teacher_id, String title, String subtitle, String background, String introduce, String content) {
        this.id = id;
        this.teacher_id = teacher_id;
        this.title = title;
        this.subtitle = subtitle;
        this.background = background;
        this.introduce = introduce;
        this.content = content;
    }

    public CourseJson(int teacher_id, String title, String subtitle, String background, String introduce, String content) {
        this.teacher_id = teacher_id;
        this.title = title;
        this.subtitle = subtitle;
        this.background = background;
        this.introduce = introduce;
        this.content = content;
    }

    public CourseJson() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
