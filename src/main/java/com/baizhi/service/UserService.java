package com.baizhi.service;

import com.baizhi.entity.User;

import java.util.List;

public interface UserService {
    List<User> queryAll(Integer page, Integer rows);
    void save(User user);
    Long findTotalCounts();
    List<User> findAlls();
}
