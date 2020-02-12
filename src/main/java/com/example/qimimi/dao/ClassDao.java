package com.example.qimimi.dao;

import com.example.qimimi.mapper.ClassMapper;
import com.example.qimimi.pojo.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClassDao {
    @Autowired
    private ClassMapper classMapper;

    public Integer AddClass(Class clas) {
        return classMapper.insert(clas);
    }

    public   List<Class> FindCurrentWeekAllClass(Integer currentweek) {
        return classMapper.FindCurrentWeekAllClass(currentweek);
    }


    public Class FindClassByid(Long classid) {
        return  classMapper.selectByPrimaryKey(classid);
    }

    public Integer UpdateClassByid(Class aClass) {
        return classMapper.updateByPrimaryKey(aClass);
    }

    public Integer DeleteClassById(long id) {
        return classMapper.deleteByPrimaryKey(id);
    }

    public Integer ExcelUpload(List<Class> list) {
        System.out.println(list.toString()+"wahaha ");
        return classMapper.ExcelUpload(list);

    }
}
