package com.example.qimimi.utils;

import com.example.qimimi.pojo.Class;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExcelUpload {
    public List<Class> importExcel(MultipartFile excelFile) throws Exception {
        File file = null;
        file=File.createTempFile("tmp", null);
        excelFile.transferTo(file);
        XSSFWorkbook workbook=new XSSFWorkbook(new FileInputStream( file));
        Sheet sheet=workbook.getSheetAt(0);
        List<Class> list=new ArrayList<>();
        int i=0;
        for(Row row : sheet){
            if(i==0){
                i=1;
                continue;
            }
            String teacher=row.getCell(0).getStringCellValue();

            String lessonName=row.getCell(1).getStringCellValue();

            String location=row.getCell(2).getStringCellValue();

            row.getCell(3).setCellType(CellType.STRING);
            String startWeek=(row.getCell(3).getStringCellValue());

            row.getCell(4).setCellType(CellType.STRING);
            String endWeek=row.getCell(4).getStringCellValue();

            String day=row.getCell(5).getStringCellValue();

            row.getCell(6).setCellType(CellType.STRING);
            String startNum=row.getCell(6).getStringCellValue();

            row.getCell(7).setCellType(CellType.STRING);
            String endNum=row.getCell(7).getStringCellValue();

            Class classs=new Class(teacher,lessonName,location,
                    Integer.parseInt(startWeek),Integer.parseInt(endWeek),day,Integer.parseInt(startNum),
                    Integer.parseInt(endNum),RandomColor.getRandColorCode(),new Date());
            list.add(classs);
        }
        return list;
    }
}
