package com.example.qimimi.pojo;

import java.util.Date;

public class Class {
    private Long id;

    private String teacher;

    private String lessonName;

    private String location;

    private Integer startWeek;

    private Integer endWeek;

    private Long testId;

    private Integer startNum;

    private Integer endNum;

    private String color;

    private String day;

    private Date creatTime;

    public Class() {
    }

    @Override
    public String toString() {
        return "Class{" +
                "id=" + id +
                ", teacher='" + teacher + '\'' +
                ", lessonName='" + lessonName + '\'' +
                ", location='" + location + '\'' +
                ", startWeek=" + startWeek +
                ", endWeek=" + endWeek +
                ", testId=" + testId +
                ", startNum=" + startNum +
                ", endNum=" + endNum +
                ", color='" + color + '\'' +
                ", day='" + day + '\'' +
                ", creatTime=" + creatTime +
                '}';
    }

    public Class(String teacher, String lessonName, String location, Integer startWeek, Integer endWeek, String day, Integer startNum, Integer endNum, String color, Date creatTime) {
        this.teacher = teacher;
        this.lessonName = lessonName;
        this.location = location;
        this.startWeek = startWeek;
        this.endWeek = endWeek;
        this.startNum = startNum;
        this.endNum = endNum;
        this.color = color;
        this.day = day;
        this.creatTime = creatTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher == null ? null : teacher.trim();
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName == null ? null : lessonName.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public Integer getStartWeek() {
        return startWeek;
    }

    public void setStartWeek(Integer startWeek) {
        this.startWeek = startWeek;
    }

    public Integer getEndWeek() {
        return endWeek;
    }

    public void setEndWeek(Integer endWeek) {
        this.endWeek = endWeek;
    }

    public Long getTestId() {
        return testId;
    }

    public void setTestId(Long testId) {
        this.testId = testId;
    }

    public Integer getStartNum() {
        return startNum;
    }

    public void setStartNum(Integer startNum) {
        this.startNum = startNum;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day == null ? null : day.trim();
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Integer getEndNum() {
        return endNum;
    }

    public void setEndNum(Integer endNum) {
        this.endNum = endNum;
    }
}