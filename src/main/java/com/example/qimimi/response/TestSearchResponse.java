package com.example.qimimi.response;

import com.example.qimimi.pojo.Test;
import lombok.Data;

import java.util.List;

@Data
public class TestSearchResponse {
    private List<Test> testList;
    private Long total;

    public List<Test> getTestList() {
        return testList;
    }

    public void setTestList(List<Test> testList) {
        this.testList = testList;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
