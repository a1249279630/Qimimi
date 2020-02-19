package com.example.qimimi.service.Impl;

import com.example.qimimi.dao.TestDao;
import com.example.qimimi.pojo.Test;
import com.example.qimimi.request.GetAllTestRequest;
import com.example.qimimi.request.InsertTestRequest;
import com.example.qimimi.service.TestService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class TestServiceImpl implements TestService {
    @Autowired
    private TestDao testDao;
    /**
     * 方法描述
     * @ 添加考试
     * @return
     * @date 2020/2/8
     */
    @Override
    public int insertTest(InsertTestRequest testRequest) {
        Test test = new Test();
        test.setName(testRequest.getName());
        test.setLocation(testRequest.getLocation());
        test.setDate(testRequest.getDate());
        test.setClock(insertTiemer(testRequest.getDate()));
        return testDao.insertTest(test);
    }
    /**
     * 方法描述
     * @ 倒计时还有多少天
     * @return long
     * @date 2020/2/8
     */
    public long insertTiemer(String date){
        //获取当前系统时间
        LocalDateTime nowTime =LocalDateTime.now();
        //将输入的时间转化为localDateTime
        //String转化为LocalDataTime
        LocalDateTime endTime = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        //时间差
        Duration duration = Duration.between(nowTime,endTime);
        //相差的天数
        long durationdays = duration.toDays();
        //相差分钟数，用于测试
        //long durationminutes = duration.toMinutes();

        return durationdays;
    }

    /**
     * 方法描述
     * @ 自动更新倒计时时间
     * @return int
     * @date 2020/2/9
     */
    @Override
    @Scheduled(cron = "0/9 * * * * *")
    public int updataClockById() {
        List<Test> tests = testDao.selectAllTest();
        List<Test> testList = new ArrayList<>();
        for(Test test : tests){
            String date = test.getDate();
            long clock = insertTiemer(date);
            log.info("还有："+clock+"天");
            if (clock<0){
                test.setClock((long)-1);
            }else {
                test.setClock(clock);
            }
            testList.add(test);
        }
        log.info("testListSize:"+testList.size()+"更新成功："+testDao.updateAllClock(testList));
        return testDao.updateAllClock(testList);
    }

    /**
     * 方法描述
     * @ 查找已过期的考试
     * @return
     * @date 2020/2/9
     */
    @Override
    public List<Test> selectClockOne() {
        return testDao.selectClockOne();
    }

    /**
     * 方法描述
     * @ 分页查询所有考试
     * @return 
     * @date 2020/2/9
     */
    @Override
    public List<Test> findAllTest(GetAllTestRequest getAllTestRequest) {
        //开始分页，必须写在上面
         Integer pageSize=7;

        Integer pageNumber = getAllTestRequest.getPageNumber();

        //Integer pageSize = getAllTestRequest.getPageSize();

        PageHelper.startPage(pageNumber,pageSize);

        List<Test> all = testDao.selectAllTest();

        PageInfo<Test> pageInfo=new PageInfo<>(all);

        log.info("all-{}",all);

        log.info("pageInfo.getList()-{}",pageInfo.getList());

        log.info("pagesize-{},pageNumber-{}",pageSize,pageNumber);

        return pageInfo.getList();
    }

    @Override
    public Integer deletTestByIds(List<Long> ids) {
        return testDao.deletTestByIds(ids);
    }
}
