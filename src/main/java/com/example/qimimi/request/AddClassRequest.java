package com.example.qimimi.request;

import java.util.Date;

public class AddClassRequest {
    private String teacher;

    private String lessonName;

    private String location;

    private Integer startWeek;

    private Integer endWeek;

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

    public Integer getStartWeek() {
        return startWeek;
    }

    public Integer getEndWeek() {
        return endWeek;
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
