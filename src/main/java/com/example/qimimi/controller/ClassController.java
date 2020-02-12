package com.example.qimimi.controller;

import com.example.qimimi.request.AddClassRequest;
import com.example.qimimi.request.UpdateClassRequest;
import com.example.qimimi.response.FindClassResponse;
import com.example.qimimi.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class ClassController {
    @Autowired
    private ClassService classService;

    @PostMapping(value = "Add/Class")
    public String AddClass(@RequestBody AddClassRequest acr){
        if(acr.getTeacher()==null||acr.getTeacher().equals("")){
            return "教师不能为空";
        }else if(acr.getLessonName()==null||acr.getLessonName().equals("")){
            return "课程名不能为空";
        }else if(acr.getStartWeek()==null||acr.getStartWeek().equals("")){
            return "开始周不能为空";
        }else if(acr.getEndWeek()==null||acr.getEndWeek().equals("")){
            return "结束周不能为空";
        }else if(acr.getDay()==null||acr.getDay().equals("")){
            return "星期几不能为空";
        }else if(acr.getStartNum()==null||acr.getStartNum().equals("")){
            return "第几节开始不能为空";
        }else if(acr.getEndNum()==null||acr.getEndNum().equals("")){
            return "第几节结束不能为空";
        }
        if(!JudgeDay(acr.getDay())){
            return "星期几课程的格式必须为‘星期（*）’";
        }

        if(acr.getStartWeek()>acr.getEndWeek()){
            return "开始周不能早于结束周";
        }
        if(acr.getStartNum()>acr.getEndNum()){
            return "开始上课不能早于结束上课";
        }
        Integer integer = classService.AddClass(acr);
        if(integer==1){
            return "添加成功";
        }else {
            return "添加失败，未知错误";
        }
    }

    @GetMapping(value = "Find/CurrentWeek/All/Class")
    public FindClassResponse[][] FindCurrentWeekAllClass(Integer currentweek){
        return classService.FindCurrentWeekAllClass(currentweek);
    }

    @PostMapping(value = "Update/Testid/by/classid")
    public Integer UpdateTestid(@RequestBody Long testid,Long classid){
        return classService.UpdateTestid(testid,classid);
    }

    @DeleteMapping(value = "Delete/Class/By/id")
    public Integer DeleteClassById(@RequestBody long id){
        return classService.DeleteClassById(id);
    }

    @PostMapping(value = "Update/Class/by/id")
    public String UpdateClassById(@RequestBody UpdateClassRequest ucr,long id){
        if(ucr.getStartNum()==null||ucr.getStartNum().equals("")){
            return "第几节开始不能为空";
        }
        classService.UpdateClassById(ucr,id);
        return "跟新成功";
    }


//   @PostMapping(value = "add/Excelupload/class")
   @RequestMapping(value = "add/Excelupload/class", method = RequestMethod.POST)
   @ResponseBody
    public Integer ExcelUpload(@RequestParam("excelFile") MultipartFile excelFile){
        return classService.ExcelUpload(excelFile);
    }


    public Boolean JudgeDay(String day){
        //定义一个正则表达式的规则
        String reg = "星期[.]*";
        //待检验的字符串
        String str =day;
        //获取一个Pattern对象
        Pattern p = Pattern.compile(reg);
        //调用matcher方法
        Matcher m = p.matcher(str);
        //查看匹配结果
        boolean flag = m.find();
        return flag;
    }
}
