package com.baizhi.serviceImpl;

import com.baizhi.dao.LogMapper;
import com.baizhi.entity.Log;
import com.baizhi.entity.LogExample;
import com.baizhi.service.LogService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service("logService")
@Transactional
public class LogServiceImpl implements LogService {
    @Resource
    private LogMapper logMapper;
    @Override
    public HashMap<String, Object> queryAllPage(Integer page, Integer rows) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("page", page);
        LogExample example = new LogExample();
        int records =logMapper.selectCountByExample(example);
        map.put("records", records);
        Integer total = records / rows == 0 ? records / rows : records / rows + 1;
        map.put("total", total);
        RowBounds rowBounds = new RowBounds((page - 1) * rows, rows);
        List<Log> logs=logMapper.selectByRowBounds(new Log(),rowBounds);
        map.put("rows", logs);
        return map;
    }
}
