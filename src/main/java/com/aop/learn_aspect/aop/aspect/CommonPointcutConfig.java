package com.aop.learn_aspect.aop.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcutConfig {

    @Pointcut("execution(* com.aop.learn_aspect.aop.business.*.*(..))")
    public void businessPackageConfig() {
    }

    @Pointcut("execution(* com.aop.learn_aspect.aop.*.*.*(..))")
    public void businessDataPackageConfig() {
    }

    @Pointcut("execution(* com.aop.learn_aspect.aop.data.*.*(..))")
    public void dataPackageConfig() {
    }

    @Pointcut("@annotation(com.aop.learn_aspect.aop.timer.TrackTimer)")
    public void trackTimerConfig(){
    }

    @Pointcut("bean(*businessService*)")
    public void serviceDataBeanConfig(){
    }

}
