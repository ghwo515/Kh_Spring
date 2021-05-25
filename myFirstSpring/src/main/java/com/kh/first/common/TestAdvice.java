package com.kh.first.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import com.kh.first.emp.model.dao.EmpDao;
import com.kh.first.emp.model.dto.EmpDto;

@Service
@Aspect
public class TestAdvice {
	
	@Pointcut("execution(* com.kh.first..*Controller.*(..))")
	public void commonPointcut() {
	}
	
	@Pointcut("execution(* com.kh.first..*Dao.*(..))")
	public void commonServicePointcut() {
	}
	
	@Pointcut("execution(String com.kh.first..*.get*(..))")
	public void commonGetPointcut() {
	}
	
	@Before("commonPointcut()")
	public void beforeMethod(JoinPoint jp) {
		String methodName = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		System.out.println("[before] "+ methodName + "() args: " + args.toString());
	}
//	@After("commonPointcut()")
//	public void afterMethod(JoinPoint jp) {
//		String methodName = jp.getSignature().getName();
//		Object[] args = jp.getArgs();
//		System.out.println("[after] "+ methodName + "() args: " + args.toString());
//	}
	@AfterReturning(pointcut="commonPointcut()", returning="returnObj")
	public void afterReturningMethod(JoinPoint jp, Object returnObj) throws Exception {
		String methodName = jp.getSignature().getName();
//		String returnStr = (String)returnObj;
		System.out.println("[after] "+ methodName + "() returnStr: " + returnObj.toString());
	}
//	@AfterReturning(pointcut="commonServicePointcut()", returning = "returnObj")
//	public void afterReturningServiceMethod(JoinPoint jp, Object returnObj) throws Exception {
//		String methodName = jp.getSignature().getName();
//		if(returnObj instanceof EmpDto) {
//			EmpDto empdto = (EmpDto)returnObj;
////			if( empdto.getDeptno() == 30) {
////				
////			}
//		}
//	}
	@AfterThrowing(pointcut="commonServicePointcut()", throwing="except")
	public void afterThrowingMethod(JoinPoint jp, Exception except) {
		String methodName = jp.getSignature().getName();
		if(except instanceof IllegalArgumentException) {
			System.out.println("아큐먼트가 맞지 ㅇ않음");
		}else if(except instanceof NumberFormatException) {
			System.out.println("숫자형태가 아님");
		}
	}
	@Around("commonServicePointcut()")
	public Object aroundMethod(ProceedingJoinPoint pjp) throws Throwable{
		String methodName = pjp.getSignature().getName();
		Object[] args = pjp.getArgs();
		System.out.println("[around-before] "+ methodName + "() args: " + args.toString());
		
		StopWatch stopwatch = new StopWatch();	// target Object 부분 실행에 소요되는 시간 확인
		stopwatch.start();
		Object returnObj = pjp.proceed();	// target Object 부분 실행
		stopwatch.stop();
		System.out.println("[around-proceed] "+ methodName + "() 소요시간: " + stopwatch.getTotalTimeMillis() + "ms");

		System.out.println("[around-after] "+ methodName + "() returnValue: " + returnObj.toString());
		return returnObj;
	}
	
}
