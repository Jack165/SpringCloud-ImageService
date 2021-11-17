package com.feng.house.util;


import java.lang.reflect.Method;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//日志处理类  增强处理类-日志
@Aspect
@Component
public class LogAop {
	private static final  Logger logger  =  LoggerFactory.getLogger(LogAop. class );

    // 前置增强  表示的是service包下的UserService下面的任意方法
	@Pointcut("@annotation(com.feng.house.util.AopMethod)")
	public void aopLog() {
	};
	
	//@Before("aopLog()")
    public void before(JoinPoint joinPoint) {
		  AopMethod controllerLog = getAnnotationLog(joinPoint);
          if (controllerLog != null)
          {
        	  logger.info(controllerLog.title()+":"+joinPoint.getSignature()+":"+JsonUtil.toString(joinPoint.getArgs()));
              //logger.info("调用" + joinPoint.getTarget() + "的"
               //       + joinPoint.getSignature() + "方法，方法参数是："
               //       + JsonUtil.toString(joinPoint.getArgs()));  
         }
  
    }

    // 后置增强pointcut表示切入点表达式   returning表示返回值
    //@AfterReturning(pointcut="aopLog()")
    public void afterReturning(JoinPoint joinPoint,Object result) {
  	  AopMethod controllerLog = getAnnotationLog(joinPoint);
      if (controllerLog == null)
      {
    	logger.info("调用" + joinPoint.getTarget() + "的"
                + joinPoint.getSignature() + "方法，方法的返回值是："
                +result);
      }
    }

    public void afterThrowingError(JoinPoint joinPoint,RuntimeException e) {
  	  AopMethod controllerLog = getAnnotationLog(joinPoint);
      if (controllerLog == null)
      {
        logger.info("调用" + joinPoint.getTarget() + "的"
                + joinPoint.getSignature().getName() + "方法，发生异常："
                +e);
      }
    }
 

    //环绕增强
    @Around("aopLog()")
    public void aroundLogger(ProceedingJoinPoint joinPoint) {
        //下面是目标方法的前面执行的处理
        logger.info("调用" + joinPoint.getTarget() + "的"
                + joinPoint.getSignature() + "方法，方法参数是："
                +JsonUtil.toString(joinPoint.getArgs()));
        Object result;//这个相当于是目标方法
        try {
            //下面是目标方法之后进行的处理
                result = joinPoint.proceed();
                logger.info("调用"+joinPoint.getTarget()+"的"+joinPoint.getSignature()+"方法，方法返回值："+JsonUtil.toString(result));

        } catch (Throwable e) {
        	e.printStackTrace();
            logger.error(joinPoint.getSignature().getName()+"方法发生异常"+e);
            e.printStackTrace();
        } finally{

        }
    }
    
    /**
     * 是否存在注解，如果存在就获取
     */
    private static AopMethod getAnnotationLog(JoinPoint joinPoint)
    {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        if (method != null)
        {
            return method.getAnnotation(AopMethod.class);
        }
        return null;
    }
}