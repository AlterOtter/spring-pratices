package com.poscoict.aoptest.aspect;

import java.nio.channels.Pipe;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class MyAspect {
	
	@Before("execution(public com.poscoict.aoptest.vo.ProductVo  com.poscoict.aoptest.service.ProductService.find(String))")
	public void beforeAdvice() {
		System.out.println("---Before Advice---");
	}
	
	@After("execution(* *..*.ProductService.*(..))")
	public void afterAdvice() {
		System.out.println("---After Advice---");
	}
	
	@AfterReturning("execution(* *..*.*.*(..))")
	public void afterReturningAdvice() {
		System.out.println("---After Returning Advice---");
	}
	
	@AfterThrowing(value = "execution(* *..*.*.*(..))",throwing="ex")
	public void afterThrowingAdvice(Throwable ex) {
		System.out.println("---After Throwing Advice---");
	}

//	
//	@Around("execution(* *..*.ProductService.*(..))")
//	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable{
//		/* before*/
//		System.out.println("--Around(Before) Advice");
//		
//		//PointCut Method()  실행
//		// 많이 쓰지는 않음
//		Object[] params = {"Camera"};
// 		Object result=pjp.proceed(params);
//		
//		
//		System.out.println("--Around(after) Advice");
//
//		
//		return result;
//	}

	
	
	@Around("execution(* *..*.ProductService.*(..))")
	public Object aroundStopWatchAdvice(ProceedingJoinPoint pjp) throws Throwable{
		/* before*/
		StopWatch sw = new StopWatch();
		sw.start();
	
 		Object result=pjp.proceed();
		
		/* After */
 		sw.stop();
 		Long totalTime = sw.getTotalTimeMillis();
		System.out.println("total time : "+totalTime.toString());
		return result;
	}
	
}
