package com.baizhi.serviceImpl;

import com.baizhi.annotation.AddLog;
import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<User> queryAll(Integer page, Integer rows) {
        int start = (page-1)*rows;
        return userDao.findAll(start,rows);
    }
    @AddLog("添加用户")
    @Override
    public void save(User user) {
        user.setId(UUID.randomUUID().toString());
        user.setCreate_date(new Date());
        userDao.save(user);
    }

    @Override
    public Long findTotalCounts() {
        return userDao.findTotalCounts();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<User> findAlls() {
        return userDao.findAlls();
    }
}
