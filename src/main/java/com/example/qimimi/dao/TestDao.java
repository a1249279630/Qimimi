package com.example.qimimi.dao;

import com.example.qimimi.mapper.TestMapper;
import com.example.qimimi.pojo.Test;
import com.example.qimimi.pojo.TestExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class TestDao {
    @Autowired
    private TestMapper testMapper;
    /**
     * 方法描述
     * @ 添加考试
     * @return
     * @date 2020/2/7
     */
    public int insertTest(Test test){
        return testMapper.insert(test);
    }


    /**
     * 方法描述
     * @ 根据查询所有Test
     * @return
     * @date 2020/2/8
     */
    public List<Test> selectAllTest(){
        TestExample testExample = new TestExample();
        return testMapper.selectByExample(testExample);
    }

    /**
     * 方法描述
     * @ 更新所有Clock
     * @return
     * @date 2020/2/9
     */
    public Integer updateAllClock(List<Test> tests){
        return testMapper.updateClock(tests);
    }

    /**
     * 方法描述
     * @ 查询 Clock=-1 的Test
     * @return
     * @date 2020/2/9
     */
    public List<Test> selectClockOne(){
        TestExample testExample = new TestExample();
        testExample.createCriteria().andClockEqualTo((long)-1);
        return testMapper.selectByExample(testExample);
    }

    /**
     * 方法描述
     * @ 批量删除考试
     * @return
     * @date 2020/2/9
     */
    public Integer deletTestByIds(List<Long> ids){
        TestExample testExample = new TestExample();
        testExample.createCriteria().andIdIn(ids);
        return testMapper.deleteByExample(testExample);
    }
}