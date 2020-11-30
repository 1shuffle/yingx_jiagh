package com.baizhi.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.Resource;
import java.util.Set;

@Configuration
@Aspect
public class CacheAspect {
    @Resource
    RedisTemplate redisTemplate;
    @Resource
    StringRedisTemplate stringRedisTemplate;
    //添加缓存
    //@Around("execution(* com.baizhi.serviceImpl.*.query*(..))")
    public Object addCache(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println("环绕通知:");
        StringRedisSerializer redisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);
        redisTemplate.setHashKeySerializer(redisSerializer);
        StringBuilder sb = new StringBuilder();
        //获取类名
        String className= proceedingJoinPoint.getTarget().getClass().getName();
        sb.append(className);
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
        Boolean aBoolean = redisTemplate.hasKey(key);
        ValueOperations string = redisTemplate.opsForValue();
        Object result=null;
        if (aBoolean){
            //key存在
            result = string.get(key);

        }else {
            //key不存在
            try {
                //放行
                result = proceedingJoinPoint.proceed();
            }catch (Throwable throwable){
                throwable.printStackTrace();
            }
            string.set(key,result);

        }

        return result;
    }
    //清除缓存
    //@After("@annotation(com.baizhi.annotation.DelCache)")
    public void delCache(JoinPoint joinPoint){
        System.out.println("后置通知：");
        //获取类的全限定名
        String className = joinPoint.getTarget().getClass().getName();
        Set<String> keys = stringRedisTemplate.keys("*");

        //遍历key
        for (String key : keys) {

            System.out.println("key: "+key);

            if(key.startsWith(className)){
                //删除键值对
                redisTemplate.delete(key);
            }
        }
    }

}
