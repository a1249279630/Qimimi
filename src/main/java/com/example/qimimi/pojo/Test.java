package com.example.qimimi.pojo;

import java.util.Date;

public class Test {
    private Long id;

    private String name;

    private String location;

    private String date;

    private Long clock;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getClock() {
        return clock;
    }

    public void setClock(Long clock) {
        this.clock = clock;
    }
}