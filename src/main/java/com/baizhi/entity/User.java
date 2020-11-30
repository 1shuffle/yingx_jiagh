package com.baizhi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    @Excel(name = "ID")
    private String id;
    @Excel(name = "姓名")
    private String nick_name;
    @Excel(name = "电话")
    private String phone;
    @Excel(name = "头像",type = 2)
    private String pic_img;
    @Excel(name = "简介")
    private String brief;
    @Excel(name = "学分")
    private Integer score;
    @Excel(name = "时间",format = "yyyy-MM-dd")
    private Date create_date;
    @Excel(name = "状态")
    private String status;
}
