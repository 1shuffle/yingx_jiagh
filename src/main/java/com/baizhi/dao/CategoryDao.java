package com.baizhi.dao;

import com.baizhi.entity.Category;
import com.baizhi.po.CategoryPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryDao {
    List<Category> findone(@Param("start") Integer start, @Param("rows") Integer rows);
    Long findTotalCounts();
   List<Category> findtwo(@Param("start") Integer start, @Param("rows") Integer rows,@Param("id") String id);
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
