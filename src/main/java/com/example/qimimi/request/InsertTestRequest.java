package com.example.qimimi.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

public class InsertTestRequest {
    private String name;
    private String location;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm", locale = "zh", timezone = "GMT+8")
    private String date;

    private Long userId;

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }

    public Long getUserId() {
        return userId;
    }
}
