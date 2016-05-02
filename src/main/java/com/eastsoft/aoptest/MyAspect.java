package com.eastsoft.aoptest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component  // Bean 생성
@Aspect        // Proxy Bean 생성
public class MyAspect {

	@Before( "execution(  public ProductVo com.eastsoft.aoptest.ProductService.findProduct(String) )" )  // JoinPoint + PointCut
	public void before() {  // advice 정의
		System.out.println( "call [Before Advice]" );
	}
	
	@After( "execution( * *..aoptest.ProductService.*(..) )" )
	public void after() {
		System.out.println( "call [after Advice]" );
	}
	
	@Around( "execution(* *..aoptest.*.*(..) )" )
	public ProductVo around(ProceedingJoinPoint pjp ) throws Throwable {
		// Before
		System.out.println( "call [around.before Advice]" );
		
		ProductVo vo = (ProductVo)pjp.proceed();
		
		// After
		System.out.println( "call [around.after Advice]" );
		
		return vo;
	}
	
	@AfterReturning( value="execution(* *..aoptest.*.*(..) )", returning="vo" )
	public void afterReturning( ProductVo vo ) {
		System.out.println( "call [afterReturning Advice] + :" + vo );
	}
	
	@AfterThrowing( value="execution(* *..aoptest.*.*(..) )", throwing="ex" )
	public void afterThrowing( Throwable ex ) {
		System.out.println( "call [afterThrowing] :" + ex );
	}
}
