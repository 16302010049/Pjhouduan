package com.example.pjhouduan.mybatis.po;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class Course {
    private int id;
    private int teacher_id;
    private String title;
    private String subtitle;
    private String background;
    private String introduce;
    private Chapter[] chapters;

    public Course(){
        System.out.println("person无参数构造函数");
    }

    public Course(int teacher_id, String title, String subtitle, String background, String introduce, Chapter[] chapters) {
        this.teacher_id = teacher_id;
        this.title = title;
        this.subtitle = subtitle;
        this.background = background;
        this.introduce = introduce;
        this.chapters = chapters;
    }

    public Course(int id, int teacher_id, String title, String subtitle, String background, String introduce, Chapter[] chapters) {
        this.id = id;
        this.teacher_id = teacher_id;
        this.title = title;
        this.subtitle = subtitle;
        this.background = background;
        this.introduce = introduce;
        this.chapters = chapters;
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

    public static Course coursejson2course(CourseJson courseJson) {
        Gson gson = new Gson();
        // 将 json 转化 成 List泛型
        List<Chapter> stus = gson.fromJson(courseJson.getContent(), new TypeToken<List<Chapter>>() {
        }.getType());
        Chapter[] chapters = new Chapter[stus.size()];
        stus.toArray(chapters);
        return new Course(courseJson.getId(), courseJson.getTeacher_id(), courseJson.getTitle(), courseJson.getSubtitle(), courseJson.getBackground(),
                courseJson.getIntroduce(), chapters);
    }

    public static CourseJson course2coursejson(Course course){
        Gson gson = new Gson();
        String content = gson.toJson(course.chapters);
        return new CourseJson(course.id,course.teacher_id,course.title,course.subtitle,course.background,course.introduce,content);
    }
}



class SingleChoice {
    private String question;
    private String choiceA;
    private String choiceB;
    private String choiceC;
    private String choiceD;
    private String right_choice;

    public SingleChoice(){

    }

    public SingleChoice(String question, String choiceA, String choiceB, String choiceC, String choiceD, String right_choice) {
        this.question = question;
        this.choiceA = choiceA;
        this.choiceB = choiceB;
        this.choiceC = choiceC;
        this.choiceD = choiceD;
        this.right_choice = right_choice;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getChoiceA() {
        return choiceA;
    }

    public void setChoiceA(String choiceA) {
        this.choiceA = choiceA;
    }

    public String getChoiceB() {
        return choiceB;
    }

    public void setChoiceB(String choiceB) {
        this.choiceB = choiceB;
    }

    public String getChoiceC() {
        return choiceC;
    }

    public void setChoiceC(String choiceC) {
        this.choiceC = choiceC;
    }

    public String getChoiceD() {
        return choiceD;
    }

    public void setChoiceD(String choiceD) {
        this.choiceD = choiceD;
    }

    public String getRight_choice() {
        return right_choice;
    }

    public void setRight_choice(String right_choice) {
        this.right_choice = right_choice;
    }
}

class Question {
    private String question;
    private String answer;

    public Question(){

    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}

class Section {
    private String sectionname;
    private  Question[] question;
    private SingleChoice[] singleChoice;

    public String getSectionname() {
        return sectionname;
    }

    public void setSectionname(String sectionname) {
        this.sectionname = sectionname;
    }

    public Question[] getQuestion() {
        return question;
    }

    public void setQuestion(Question[] question) {
        this.question = question;
    }

    public SingleChoice[] getSingleChoice() {
        return singleChoice;
    }

    public void setSingleChoice(SingleChoice[] singleChoice) {
        this.singleChoice = singleChoice;
    }
}

class Chapter {
    private String chapter_name;
    private Section[] section;

    public Chapter(){

    }

    public Chapter(String chapter_name, Section[] section) {
        this.chapter_name = chapter_name;
        this.section = section;
    }

    public String getChapter_name() {
        return chapter_name;
    }

    public void setChapter_name(String chapter_name) {
        this.chapter_name = chapter_name;
    }

    public Section[] getSection() {
        return section;
    }

    public void setSection(Section[] section) {
        this.section = section;
    }
}
