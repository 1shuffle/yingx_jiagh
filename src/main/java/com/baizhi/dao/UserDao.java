package com.baizhi.dao;

import com.baizhi.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    void save(User user);
    List<User> findAll(@Param("start") Integer start, @Param("rows") Integer rows);
    Long findTotalCounts();
    Long findSearchTotalCounts(@Param("searchField")String searchField, @Param("searchOper")String searchOper, @Param("searchString")String searchString);
    List<User> findAllSearch(@Param("start")int start, @Param("rows")Integer rows, @Param("searchField")String searchField, @Param("searchOper")String searchOper, @Param("searchString")String searchString);
    List<User> findAlls();
}
