package com.example.qimimi.response;

import com.example.qimimi.pojo.Test;
import lombok.Data;

import java.util.List;

@Data
public class TestSearchResponse {
    private List<Test> testList;
    private Long total;
}
