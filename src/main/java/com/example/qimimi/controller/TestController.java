package com.example.qimimi.controller;

import com.example.qimimi.common.JsonResult;
import com.example.qimimi.pojo.Test;
import com.example.qimimi.request.GetAllTestRequest;
import com.example.qimimi.request.InsertTestRequest;
import com.example.qimimi.response.SelectClockOneResponse;
import com.example.qimimi.response.TestSearchResponse;
import com.example.qimimi.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class TestController {
    @Autowired
    private TestService testService;
    /**
     * 方法描述
     * @ 添加考试
     * @return String
     * @date 2020/2/7
     */
    @PostMapping(value = "insert/Test")
    public String insertTest(@RequestBody InsertTestRequest testRequest){

        int test = testService.insertTest(testRequest);
        log.info("request:"+testRequest.getDate());
        if(test==1){
            return "添加成功";
        }else {
            return "添加失败";
        }
    }

    /**
     * 方法描述
     * @ 查找已过期的考试
     * @return
     * @date 2020/2/9
     */
    @GetMapping(value = "select/OneClock")
    public JsonResult<SelectClockOneResponse> selectClockOne(Long userId){
        return JsonResult.ok(testService.selectClockOne(userId));
    }

    /**
     * 方法描述
     * @ 分页查询所有考试
     * pageSize：页数大小，比如一页显示两个
     * pageNumber：查看第几页的
     * @return
     * @date 2020/2/9
     */
    @PostMapping("all/test")
    public JsonResult<TestSearchResponse> getAllTestById(@RequestBody GetAllTestRequest getAllTestRequest,Long userId){

        return JsonResult.ok(testService.findAllTest(getAllTestRequest,userId));
    }
    
    /**
     * 方法描述
     * @ 批量删除
     * @return 
     * @date 2020/2/9
     */
    @PostMapping(value = "delete/Test")
    public JsonResult<String> deleteTestByIds(@RequestParam(value = "id") List<Long> ids,Long userId){
        Integer integer = testService.deletTestByIds(ids,userId);
        log.info("integer"+integer);
        if(integer!=null) {
            return JsonResult.ok("删除成功"+integer+"个");
        }else {
            return JsonResult.ok("删除失败");
        }
    }
}
