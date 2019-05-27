DROP TABLE IF EXISTS Teacher;
CREATE TABLE IF NOT EXISTS Teacher
(
    id       INT  NOT NULL AUTO_INCREMENT,
    name     Text NOT NULL,
    password Text NOT NULL,
    head     Text NOT NULL,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS Student;
CREATE TABLE IF NOT EXISTS Student
(
    id            INT  NOT NULL AUTO_INCREMENT,
    signature     TEXT NOT NULL,
    mailbox       TEXT,
    sex           TEXT,
    name          TEXT,
    studentnumber TEXT,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS Collect;
CREATE TABLE IF NOT EXISTS Collect
(
    id       INT NOT NULL AUTO_INCREMENT,
    stu_id   INT NOT NULL,
    question TEXT,
    answer   TEXT,
    note     TEXT,
    PRIMARY KEY (id),
    FOREIGN KEY (stu_id) REFERENCES Student (id)
);

DROP TABLE IF EXISTS Course;
CREATE TABLE IF NOT EXISTS Course
(
    id         INT  NOT NULL AUTO_INCREMENT,
    teacher_id INT  NOT NULL,
    title      TEXT NOT NULL,
    subtitle   TEXT,
    background TEXT,
    introduce  TEXT,
    content    JSON,
    PRIMARY KEY (id),
    FOREIGN KEY (teacher_id) REFERENCES Teacher (id)
);

DROP TABLE IF EXISTS AnswerRecord;
CREATE TABLE IF NOT EXISTS AnswerRecord
(
    id         INT  NOT NULL AUTO_INCREMENT,
    student_id INT  NOT NULL,
    course_id  INT  NOT NULL,
    chapter    TEXT NOT NULL,
    section    TEXT NOT NULL,
    question   TEXT NOT NULL,
    choice     TEXT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (student_id) REFERENCES Student (id),
    FOREIGN KEY (course_id) REFERENCES Course (id)
);

DROP TABLE IF EXISTS CourseStudent;
CREATE TABLE IF NOT EXISTS CourseStudent
(
    id           INT NOT NULL AUTO_INCREMENT,
    course_id    INT NOT NULL,
    student_id   INT NOT NULL,
    progress     FLOAT NOT NULL,
    studysection JSON,
    PRIMARY KEY (id),
    FOREIGN KEY (course_id) REFERENCES Course (id),
    FOREIGN KEY (student_id) REFERENCES Student (id)
)