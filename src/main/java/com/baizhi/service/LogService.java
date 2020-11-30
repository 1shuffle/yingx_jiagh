package com.baizhi.service;

import java.util.HashMap;

public interface LogService {
    HashMap<String,Object> queryAllPage(Integer page,Integer rows);
}
