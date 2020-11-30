package com.baizhi.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.Resource;

@Configuration
@Aspect
public class CacheHashAspect {
    @Resource
    RedisTemplate redisTemplate;
    @Resource
    StringRedisTemplate stringRedisTemplate;
    //添加缓存
    @Around("execution(* com.baizhi.serviceImpl.*.query*(..))")
    public Object addCache(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println("环绕通知:");
        StringRedisSerializer redisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);
        redisTemplate.setHashKeySerializer(redisSerializer);
        StringBuilder sb = new StringBuilder();
        //获取类名
        String className= proceedingJoinPoint.getTarget().getClass().getName();

        //获取方法名
        String methodName=proceedingJoinPoint.getSignature().getName();
        sb.append(methodName);
        //获取参数
        Object[] args = proceedingJoinPoint.getArgs();
        for (Object arg: args){
            sb.append(arg);
        }
        String key=sb.toString();
        //判断key是否存在 if不存在 没有缓存（放行,返回数据）
        HashOperations opsForHash = redisTemplate.opsForHash();
        Boolean aBoolean = opsForHash.hasKey(className, key);
        Object result=null;
        if (aBoolean){
            //key存在
            result = opsForHash.get(className,key);

        }else {
            //key不存在
            try {
                //放行
                result = proceedingJoinPoint.proceed();
            }catch (Throwable throwable){
                throwable.printStackTrace();
            }
            opsForHash.put(className,key,result);

        }

        return result;
    }
    //清除缓存
    @After("@annotation(com.baizhi.annotation.DelCache)")
    public void delCache(JoinPoint joinPoint){
        System.out.println("后置通知：");
        //获取类的全限定名
        String className = joinPoint.getTarget().getClass().getName();
        //清除缓存
        redisTemplate.delete(className);
    }

}
