package com.example.spring.security.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;


/**
 * 定义日志切面 ，在进入到方法前和方法后，都要执行日志通知
 */

@Aspect
@Component
public class LogAspectJ {

   private final Logger logger= LoggerFactory.getLogger(this.getClass());


    /**
     * 自定义切点PointCut匹配哪些类,,execution表示执行方法时触发，*表示返回任意类型(..)表示方法的任意参数
     */
    @Pointcut("execution(public * com.example.spring..*.*(..))")
    public void print(){
    }

    @Around("print()")
    public Object logArount(ProceedingJoinPoint joinPoint) throws Exception {
        if (logger.isDebugEnabled()){
            //必须设置日志的级别为可调式的
            logger.debug("Enter: {}.{}() with argument[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
                    joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
        }

        try{
            Object result=joinPoint.proceed();
            if (logger.isDebugEnabled()) {
                logger.debug("Exit: {}.{}() with result = {}", joinPoint.getSignature().getDeclaringTypeName(),
                        joinPoint.getSignature().getName(), result);
            }
            return result;
        }catch (Exception e){
              throw e;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }



}
