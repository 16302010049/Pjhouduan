package com.example.pjhouduan.response;

public class StudentListResponse {
  private int student_id;
  private String name;
  private String studentnumber;
  private float progress;

    public StudentListResponse(int student_id, String name, String studentnumber, float progress) {
        this.student_id = student_id;
        this.name = name;
        this.studentnumber = studentnumber;
        this.progress = progress;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentnumber() {
        return studentnumber;
    }

    public void setStudentnumber(String studentnumber) {
        this.studentnumber = studentnumber;
    }

    public float getProgress() {
        return progress;
    }

    public void setProgress(float progress) {
        this.progress = progress;
    }
}
