package com.example.smalllee.myapplication.aop.aspect;

import android.util.Log;

import com.example.smalllee.myapplication.aop.anotation.BehaviorTrace;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 描述：
 * @author Create by lxn on 2019/3/4
 */
// Aspect说明是一个切面类，切面类中包含切点和如何处理切点
@Aspect
public class BehaviorAspect {
    private static final String TAG = "BehaviorAspect";
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
    // Pointcut定义切点，就是处理什么地方
    @Pointcut("execution(@com.example.smalllee.myapplication.aop.anotation.BehaviorTrace * *(..))")
    public void annoBehaviorTrace(){};

    /*
    * @Before 可以在方法前插入代码
    * @After 可以在方法后插入代码
    * @Around 可以在方法前后插入代码
    * */
    @Around("annoBehaviorTrace()")
    public Object processPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        long begin = System.currentTimeMillis();
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        BehaviorTrace behaviorTrace = methodSignature.getMethod().getAnnotation(BehaviorTrace.class);
        String funcName = behaviorTrace.value();
        Log.d(TAG, funcName + "功能: " + sdf.format(new Date()));
        Object result = joinPoint.proceed();
        Log.d(TAG, "耗时: " + (System.currentTimeMillis() - begin) + "ms");
        return result;
    }
}
