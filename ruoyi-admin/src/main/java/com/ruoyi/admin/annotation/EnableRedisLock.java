package com.ruoyi.admin.annotation;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: yangguohui
 * @Date: 2023/8/31 16:36
 * @Description:
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EnableRedisLock {

    public String lockKey() default "lock";
    public long expireTime() default 60;
    public TimeUnit timeUnit() default TimeUnit.SECONDS;

}
