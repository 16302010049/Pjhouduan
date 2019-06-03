package com.example.pjhouduan.mybatis.po;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class CourseStuJson {
    private int id;
    private int teacher_id;
    private String title;
    private String subtitle;
    private String background;
    private String introduce;
    private String content;
    private String teacher_name;
    private String teacher_head;

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

    public static CourseStu coursestujson2coursestu(CourseStuJson courseStuJson) {
        Gson gson = new Gson();
        // 将 json 转化 成 List泛型
        List<Chapter> stus = gson.fromJson(courseStuJson.getContent(), new TypeToken<List<Chapter>>() {
        }.getType());
        Chapter[] chapters = new Chapter[stus.size()];
        stus.toArray(chapters);
        return new CourseStu(courseStuJson.id,courseStuJson.teacher_id,courseStuJson.title,courseStuJson.subtitle,courseStuJson.background,courseStuJson.introduce,
                chapters,courseStuJson.teacher_name,courseStuJson.teacher_head);
    }
}
