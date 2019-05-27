package com.example.pjhouduan.mybatis.po;

public class AnswerRecord {
    private int id;
    private int student_id;
    private int course_id ;
    private String chapter;
    private String section;
    private String question;
    private String choice;

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public String getChapter() {
        return chapter;
    }

    public String getChoice() {
        return choice;
    }

    public String getQuestion() {
        return question;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public void setChoice(String answer) {
        this.choice = answer;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
