package com.example.qimimi.request;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class InsertTestRequest {
    private String name;
    private String location;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm", locale = "zh", timezone = "GMT+8")
    private String date;

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }
}
