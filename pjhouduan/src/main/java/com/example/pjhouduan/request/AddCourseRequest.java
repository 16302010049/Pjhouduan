package com.example.pjhouduan.request;

public class AddCourseRequest {
    private int id;
    private String course_id;
    private String student_id;
    private float progress;
    private String studysection;
    public AddCourseRequest(){

    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public void setStudysection(String section){
        this.studysection=section;
    }

    public String getCourse_id() {
        return course_id;
    }

    public String getStudysection() {
        return studysection;
    }

    public int getId() {
        return id;
    }

    public float getProgress() {
        return progress;
    }

    public void setProgress(float progress) {
        this.progress = progress;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
