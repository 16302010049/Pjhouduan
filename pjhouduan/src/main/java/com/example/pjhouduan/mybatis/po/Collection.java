package com.example.pjhouduan.mybatis.po;

public class Collection {
    private int id;
    private int stu_id;
    private String question;
    private String answer;
    private String note;

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(String choice) {
        this.answer = choice;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStu_id() {
        return stu_id;
    }

    public String getNote() {
        return note;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
