package com.ruoyi.admin.tools;

import com.ruoyi.admin.annotation.EnableRedisLock;
import com.ruoyi.common.redis.service.RedisService;
import io.lettuce.core.RedisClient;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: yangguohui
 * @Date: 2023/8/31 16:33
 * @Description:
 */

@Aspect
@Component
public class RedisLockAspect {
    @Autowired
    private RedisService redisService;

    @Around(value = "@annotation(enableRedisLock)")
    public void handleRedisLock(ProceedingJoinPoint joinPoint, EnableRedisLock enableRedisLock)
            throws Throwable {

        // 获取注解对象的变量值
        String lockKey = enableRedisLock.lockKey();
        long expireTime = enableRedisLock.expireTime();
        TimeUnit timeUnit = enableRedisLock.timeUnit();
        String value = UUID.randomUUID().toString();

        // 获取锁
        if (redisService.tryLock(lockKey, value, expireTime, timeUnit,10)) {
            try {
                // 获取锁成功继续执行业务逻辑
                joinPoint.proceed();
            } finally {
               redisService.releseLock(lockKey, value);
            }
        }
    }
}
