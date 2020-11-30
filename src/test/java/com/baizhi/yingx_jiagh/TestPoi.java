package com.baizhi.yingx_jiagh;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@SpringBootTest
public class TestPoi {

    @Test
    public void testPoi() throws IOException {
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet1=workbook.createSheet("学生信息表1");
        //创建一行
        Row row = sheet1.createRow(1);
        //创建一个单元格
        Cell cell = row.createCell(2);
        cell.setCellValue("第二行，第三个单元格");
        workbook.write(new FileOutputStream(new File("D:\\testPoi.xls")));
        //Sheet sheet2=workbook.createSheet("学生信息表2");
    }

}
