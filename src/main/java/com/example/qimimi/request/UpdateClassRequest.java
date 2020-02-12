package com.example.qimimi.request;

public class UpdateClassRequest {
    private String teacher;

    private String lessonName;

    private String location;

    private Long testId;

    private Integer startNum;

    private Integer endNum;

    private String day;

    public String getTeacher() {
        return teacher;
    }

    public String getLessonName() {
        return lessonName;
    }

    public String getLocation() {
        return location;
    }

    public Long getTestId() {
        return testId;
    }

    public Integer getStartNum() {
        return startNum;
    }

    public Integer getEndNum() {
        return endNum;
    }

    public String getDay() {
        return day;
    }
}
