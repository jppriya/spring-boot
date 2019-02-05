package com.jp.poc.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class SampleAdvice {

	private Logger LOGGER = LoggerFactory.getLogger(SampleAdvice.class);

	// We can mention all the common joinpoints as pointcut. So that instead of
	// mentioning in each advice we can use the pointcut declaration
	@Pointcut(value = "execution(* com.jp.poc.service.impl.*.*(..))")
	private void doServiceLayerExecution() {
	};

	@Before("doServiceLayerExecution()")
	public void before(JoinPoint jointPoint) {
		LOGGER.info("This method is called in before Aspect");
	}

	@After("doServiceLayerExecution()")
	public void after(JoinPoint jointPoint) {
		LOGGER.info("after");
	}

//	@Around("execution(* com.jp.poc.exceptionhandling.service.impl.*.*(..))")
//
//	public void around(ProceedingJoinPoint jointcut) throws Throwable {
//		System.out.println("Before Around");
//		jointcut.proceed();
//		System.out.println("After around");
//	}

	@AfterReturning(value = "execution(* com.jp.poc.service.impl.*.*(..))", returning = "result")
	public void afterReturning(JoinPoint jointPoint, Object result) {
		LOGGER.info("afterReturnisng" + result);
	}

	@AfterThrowing(pointcut = "doServiceLayerExecution()", throwing = "exception")
	public void afterThrowing(JoinPoint joinPoint, Exception exception) {
		LOGGER.info("After throwing exception", exception);
	}
}
