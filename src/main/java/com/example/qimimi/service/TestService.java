package com.example.qimimi.service;

import com.example.qimimi.pojo.Test;
import com.example.qimimi.request.GetAllTestRequest;
import com.example.qimimi.request.InsertTestRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TestService {

    int insertTest(InsertTestRequest testRequest);

    int updataClockById();

    List<Test> selectClockOne(Long userId);

    List<Test> findAllTest(GetAllTestRequest getAllTestRequest,Long userId);

    Integer deletTestByIds(List<Long> ids,Long userId);
}
