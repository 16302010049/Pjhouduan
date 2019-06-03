package com.example.pjhouduan.mybatis.po;

public class CourseStu {
    private int id;
    private int teacher_id;
    private String title;
    private String subtitle;
    private String background;
    private String introduce;
    private Chapter[] chapters;
    private String teacher_name;
    private String teacher_head;

    public CourseStu(int id, int teacher_id, String title, String subtitle, String background, String introduce, Chapter[] chapters, String teacher_name, String teacher_head) {
        this.id = id;
        this.teacher_id = teacher_id;
        this.title = title;
        this.subtitle = subtitle;
        this.background = background;
        this.introduce = introduce;
        this.chapters = chapters;
        this.teacher_name = teacher_name;
        this.teacher_head = teacher_head;
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

    public Chapter[] getChapters() {
        return chapters;
    }

    public void setChapters(Chapter[] chapters) {
        this.chapters = chapters;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getTeacher_head() {
        return teacher_head;
    }

    public void setTeacher_head(String teacher_head) {
        this.teacher_head = teacher_head;
    }
}
