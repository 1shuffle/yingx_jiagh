package com.baizhi.controller;

import com.alibaba.druid.util.StringUtils;
import com.baizhi.entity.Category;
import com.baizhi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("findone")
    @ResponseBody
    public Map<String,Object> findone(Integer page, Integer rows){
        HashMap<String, Object> result = new HashMap<>();
        //查询结果
        List<Category> c=categoryService.findone(page,rows);
        //总条数
        Long totalCounts = categoryService.findTotalCounts();
        //总页数
        Long totalPage = totalCounts%rows==0?totalCounts/rows:(totalCounts/rows)+1;
        result.put("page",page);//当前页
        result.put("total",totalPage);//总页数
        result.put("records",totalCounts);
        result.put("rows",c);
        return result;
    }
    @RequestMapping("findtwo")
    @ResponseBody
    public Map<String,Object> findtwo(Integer page, Integer rows,String id){
        HashMap<String, Object> result = new HashMap<>();
        //查询结果
        List<Category> c=categoryService.findtwo(page,rows,id);
        //总条数
        Long totalCounts = categoryService.findTotalCounts();
        //总页数
        Long totalPage = totalCounts%rows==0?totalCounts/rows:(totalCounts/rows)+1;
        result.put("page",page);//当前页
        result.put("total",totalPage);//总页数
        result.put("records",totalCounts);
        result.put("rows",c);
        return result;
    }

    @RequestMapping("edit")
    @ResponseBody
    public  void edit(Category category,String oper){
        //判断是什么操作
        if(StringUtils.equals("add",oper)){
            categoryService.saveone(category);
        }
        if(StringUtils.equals("edit",oper)){
          categoryService.updateone(category);
        }
        if(StringUtils.equals("del",oper)){
          categoryService.deleteone(category.getId());
        }
    }
    @RequestMapping("edit1")
    @ResponseBody
    public  void edit1(Category category,String oper){
        //判断是什么操作
        if(StringUtils.equals("add",oper)){
            categoryService.savetwo(category);
        }
        if(StringUtils.equals("edit",oper)){
            categoryService.updatetwo(category);
        }
        if(StringUtils.equals("del",oper)){
            categoryService.deletetwo(category.getId());
        }
    }
}
