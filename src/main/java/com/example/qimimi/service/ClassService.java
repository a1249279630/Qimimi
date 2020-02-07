package com.example.qimimi.service;

import com.example.qimimi.request.AddClassRequest;
import com.example.qimimi.request.UpdateClassRequest;
import com.example.qimimi.response.FindClassResponse;
import org.springframework.stereotype.Service;

@Service
public interface ClassService {
    Integer AddClass(AddClassRequest addClassRequest);

    FindClassResponse[][] FindCurrentWeekAllClass(Integer currentweek);

    Integer UpdateTestid(Long testid,Long classid);

    Integer DeleteClassById(long id);

    Integer UpdateClassById(UpdateClassRequest ucr, long id);
}
