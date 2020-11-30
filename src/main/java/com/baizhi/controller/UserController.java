package com.baizhi.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.util.AliyunUtil;
import com.baizhi.util.ImageCodeUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {
  @Autowired
    private UserService userService;
  @RequestMapping("findAll")
  @ResponseBody
  public Map<String,Object> findAll(Integer page, Integer rows){
    HashMap<String, Object> result = new HashMap<>();
    //查询结果
    List<User> u=userService.queryAll(page,rows);

    //总条数
      Long totalCounts = userService.findTotalCounts();
      //总页数
      Long totalPage = totalCounts%rows==0?totalCounts/rows:(totalCounts/rows)+1;
    result.put("page",page);//当前页
      result.put("total",totalPage);//总页数
      result.put("records",totalCounts);
    result.put("rows",u);
      return result;
  }
    @RequestMapping("findAlls")
    @ResponseBody
    public List<User> findAlls(){
       List<User> uu=userService.findAlls();
       return uu;
    }
 @RequestMapping("phone")
  public static void xcode(String phonenumbers){
    //获取随机验证码字符
   String securityCode = ImageCodeUtil.getSecurityCode();
   //发送验证码
   AliyunUtil.phone(phonenumbers,securityCode);
 }
 @RequestMapping("poi")
    public void poi(){
     List<User> all=userService.findAlls();
    for (User users:all){
        String img= users.getPic_img();
    String path="C:\\Users\\jiagu\\IdeaProjects\\codes\\yingx_jiagh\\src\\main\\webapp\\bootstrap\\img\\";
    String newPath=path+img;
    users.setPic_img(newPath);
    }
     ExportParams exportParams = new ExportParams("用户信息", "用户");
     Workbook workbook = ExcelExportUtil.exportExcel(exportParams,User.class,all);
     try {
         //导出
         workbook.write(new FileOutputStream(new File("D:\\Easypois.xls")));
     } catch (IOException e) {
         e.printStackTrace();
     }
 }

}
