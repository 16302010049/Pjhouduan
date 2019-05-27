package com.example.pjhouduan.response;

public class AnswerRecordResponse {
    private int id;
    private String name;
    private String choice;
    private  String question;

    public AnswerRecordResponse(int id, String name, String choice) {
        this.id = id;
        this.name = name;
        this.choice = choice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
