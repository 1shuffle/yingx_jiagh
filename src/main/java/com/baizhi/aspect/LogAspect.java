package com.baizhi.aspect;

import com.baizhi.annotation.AddLog;
import com.baizhi.dao.LogMapper;
import com.baizhi.entity.Admin;
import com.baizhi.entity.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.UUID;

@Configuration
@Aspect
public class LogAspect {
    @Resource
    HttpServletRequest request;
    @Resource
    private LogMapper logMapper;
    //@Around("@annotation(com.baizhi.annotation.AddLog)")
    public Object addLog(ProceedingJoinPoint proceedingJoinPoint){
        Admin admin = (Admin) request.getSession().getAttribute("admin");
        String methodName = proceedingJoinPoint.getSignature().getName();
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = signature.getMethod();
        //获取注解
        AddLog addLog = method.getAnnotation(AddLog.class);
        //获取注解对应的属性值
        String value = addLog.value();
        String message=null;
        Object result =null;
        //放行方法
        try {
            result = proceedingJoinPoint.proceed();

            String s = result.toString();

            message="success";
        } catch (Throwable throwable) {
            message="error";
        }
        Log log = new Log();
        log.setId(UUID.randomUUID().toString());
        log.setName(admin.getUsername());
        log.setTimes(new Date());
        log.setOption(methodName+"("+value+")");
        log.setStatus(message);
        logMapper.insert(log);
        System.out.println("数据入库"+log);
        return result;
    }
}
