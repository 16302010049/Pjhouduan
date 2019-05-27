package com.example.pjhouduan.request;

/**
 * Created by zt02 on 2019/5/26.
 */
public class UpdatePro {
    private int course_id;
    private int student_id;
    private String section;

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }
}
