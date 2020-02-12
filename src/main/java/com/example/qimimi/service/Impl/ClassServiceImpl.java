package com.example.qimimi.service.Impl;

import com.example.qimimi.dao.ClassDao;
import com.example.qimimi.pojo.Class;
import com.example.qimimi.request.AddClassRequest;
import com.example.qimimi.request.UpdateClassRequest;
import com.example.qimimi.response.FindClassResponse;
import com.example.qimimi.service.ClassService;
import com.example.qimimi.utils.ExcelUpload;
import com.example.qimimi.utils.RandomColor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;
import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    private ClassDao classDao;
    @Override
    public Integer AddClass(AddClassRequest acr) {
        try {
            Class clas=new Class();
            clas.setLessonName(acr.getLessonName());
            clas.setLocation(acr.getLocation());
            clas.setStartNum(acr.getStartNum());
            clas.setEndNum(acr.getEndNum());
            clas.setTeacher(acr.getTeacher());
            clas.setStartWeek(acr.getStartWeek());
            clas.setEndWeek(acr.getEndWeek());
            clas.setDay(acr.getDay());
            clas.setCreatTime(new Date());
            clas.setColor(RandomColor.getRandColorCode());
            return classDao.AddClass(clas);
        }catch (Exception e){
            return -1;
        }
    }

    @Override
    public FindClassResponse[][] FindCurrentWeekAllClass(Integer currentweek) {
        System.out.println("asdf");
        List<Class> classes = classDao.FindCurrentWeekAllClass(currentweek);
        System.out.println(classes.toString()+"tafg ");
        FindClassResponse arrays[][] =new FindClassResponse[7][8];
        Class day1[]=new Class[8];
        Class day2[]=new Class[8];
        Class day3[]=new Class[8];
        Class day4[]=new Class[8];
        Class day5[]=new Class[8];
        Class day6[]=new Class[8];
        Class day7[]=new Class[8];
        if(!CollectionUtils.isEmpty(classes)){
            int i1=0,i2=0,i3=0,i4=0,i5=0,i6=0,i7=0;
            for(Class c:classes){
                if(c.getDay().equals("星期一")){
                    BeanUtils.copyProperties(c,day1[i1]=new Class());
                    i1++;
                }else if(c.getDay().equals("星期二")){
                    BeanUtils.copyProperties(c,day2[i2]=new Class());
                    i2++;
                }else if(c.getDay().equals("星期三")){
                    BeanUtils.copyProperties(c,day3[i3]=new Class());
                    i3++;
                }else if(c.getDay().equals("星期四")){
                    BeanUtils.copyProperties(c,day4[i4]=new Class());
                    i4++;
                }else if(c.getDay().equals("星期五")){
                    BeanUtils.copyProperties(c,day5[i5]=new Class());
                    i5++;
                }else if(c.getDay().equals("星期六")){
                    BeanUtils.copyProperties(c,day6[i6]=new Class());
                    i6++;
                }else if(c.getDay().equals("星期日")){
                    BeanUtils.copyProperties(c,day7[i7]=new Class());
                    i7++;
                }
            }
            for(int i=0;i<8;i++){
                try {
                    if (day1[i].getStartNum() != null) {
                        BeanUtils.copyProperties(ShowFindClassResponse(day1[i]), arrays[0][day1[i].getStartNum()-1] = new FindClassResponse());
                    }
                }catch (Exception e){ }
                try {
                    if(day2[i].getStartNum()!=null){
                        BeanUtils.copyProperties(ShowFindClassResponse(day2[i]),arrays[1][day2[i].getStartNum()-1]=new FindClassResponse());
                    }
                }catch (Exception e){ }
                try {
                    if(day3[i].getStartNum()!=null){
                        BeanUtils.copyProperties(ShowFindClassResponse(day3[i]),arrays[2][day3[i].getStartNum()-1]=new FindClassResponse());
                    }
                }catch (Exception e){ }
                try {
                    if(day4[i].getStartNum()!=null){
                        BeanUtils.copyProperties(ShowFindClassResponse(day4[i]),arrays[3][day4[i].getStartNum()-1]=new FindClassResponse());
                    }
                }catch (Exception e){ }
                try {
                    if(day5[i].getStartNum()!=null){
                        BeanUtils.copyProperties(ShowFindClassResponse(day5[i]),arrays[4][day5[i].getStartNum()-1]=new FindClassResponse());
                    }
                }catch (Exception e){ }
                try {
                    if(day6[i].getStartNum()!=null){
                        BeanUtils.copyProperties(ShowFindClassResponse(day6[i]),arrays[5][day6[i].getStartNum()-1]=new FindClassResponse());
                    }
                }catch (Exception e){ }
                try {
                    if(day7[i].getStartNum()!=null){
                        BeanUtils.copyProperties(ShowFindClassResponse(day7[i]),arrays[6][day7[i].getStartNum()-1]=new FindClassResponse());
                    }
                }catch (Exception e){ }
            }
        }
        return arrays;
    }

    @Override
    public Integer UpdateTestid(Long testid,Long classid) {
        Class aClass = classDao.FindClassByid(classid);
        aClass.setTestId(testid);
        return classDao.UpdateClassByid(aClass);

    }

    @Override
    public Integer DeleteClassById(long id) {
        return classDao.DeleteClassById(id);
    }

    @Override
    public Integer UpdateClassById(UpdateClassRequest ucr, long id) {
        Class aClass = classDao.FindClassByid(id);
        aClass.setStartNum(ucr.getStartNum());
        aClass.setEndNum(ucr.getEndNum());
        aClass.setTeacher(ucr.getTeacher());
        aClass.setLessonName(ucr.getLessonName());
        aClass.setLocation(ucr.getLocation());
        aClass.setDay(ucr.getDay());
        aClass.setTestId(ucr.getTestId());
        return classDao.UpdateClassByid(aClass);
    }

    @Override
    public Integer ExcelUpload(MultipartFile excelFile) {
        ExcelUpload excelUpload=new ExcelUpload();
        try {
            List<Class> list = excelUpload.importExcel(excelFile);
            return classDao.ExcelUpload(list);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    private FindClassResponse ShowFindClassResponse(Class classes) {
        FindClassResponse findClassResponse=new FindClassResponse();
            BeanUtils.copyProperties(classes,findClassResponse);
            findClassResponse.setNum(classes.getStartNum()+"-"+classes.getEndNum());
        return findClassResponse;
    }

}
