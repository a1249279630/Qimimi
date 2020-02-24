package com.example.qimimi.response;

import lombok.Data;

@Data
public class SelectClockOneResponse {
    private String name;

    private String location;

    private String date;

    private Long clock;
}
