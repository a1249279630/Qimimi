package com.example.qimimi.service;

import com.example.qimimi.pojo.Test;
import com.example.qimimi.request.InsertTestRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TestService {

    int insertTest(InsertTestRequest testRequest);

    int updataClockById();

    List<Test> selectClockOne();

    List<Test> findAllTest(Integer pageSize, Integer pageNumber);

    Integer deletTestByIds(List<Long> ids);
}
