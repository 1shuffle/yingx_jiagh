package com.baizhi.service;

import com.baizhi.entity.Category;
import com.baizhi.po.CategoryPO;

import java.util.List;

public interface CategoryService {
    List<Category> findone(Integer page, Integer rows);
    List<Category> findtwo(Integer page, Integer rows,String id);
    Long findTotalCounts();
    Long countss();
    //添加一级信息
    void saveone(Category category);
    //添加二级信息
    void savetwo(Category category);
    //修改一级信息
    void updateone(Category category);
    //修改二级信息
    void updatetwo(Category category);
    //删除一级信息
    void deleteone(String id);
    //删除二级信息
    void deletetwo(String id);
    List<CategoryPO> queryAllCategory();

}
