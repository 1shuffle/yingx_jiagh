package com.baizhi.serviceImpl;

import com.baizhi.annotation.AddLog;
import com.baizhi.annotation.DelCache;
import com.baizhi.dao.CategoryDao;
import com.baizhi.entity.Category;
import com.baizhi.po.CategoryPO;
import com.baizhi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service("categoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;


    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Category> findone(Integer page, Integer rows) {
        int start = (page-1)*rows;
        return categoryDao.findone(start,rows);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Category> findtwo(Integer page, Integer rows,String id) {
        int start = (page-1)*rows;
        return categoryDao.findtwo(start,rows,id);
    }

    @Override
    public Long findTotalCounts() {
        return categoryDao.findTotalCounts();
    }

    @Override
    public Long countss() {
        return categoryDao.countss();
    }
    @DelCache
    @AddLog("添加类别")
    @Override
    public void saveone(Category category) {
        categoryDao.saveone(category);
    }
    @DelCache
    @AddLog("添加类别2")
    @Override
    public void savetwo(Category category) {
        categoryDao.savetwo(category);
    }
    @DelCache
    @AddLog("修改类别")
    @Override
    public void updateone(Category category) {
        categoryDao.updateone(category);
    }
    @DelCache
    @AddLog("修改二级类别")
    @Override
    public void updatetwo(Category category) {
        categoryDao.updatetwo(category);
    }
    @DelCache
    @AddLog("删除类别")
    @Override
    public void deleteone(String id) {
        categoryDao.deleteone(id);
    }
    @DelCache
    @AddLog("删除二级类别")
    @Override
    public void deletetwo(String id) {
        categoryDao.deletetwo(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<CategoryPO> queryAllCategory() {
        categoryDao.queryAllCategory();
        return categoryDao.queryAllCategory();
    }
}
