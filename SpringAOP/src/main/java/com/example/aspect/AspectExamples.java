package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component("myAspect")
@Aspect
public class AspectExamples {
	
	public AspectExamples() {
		
	}
	
	/*
	 * Pointcut expressions are used to select joinpoints, or in other words pointcuts target a subset of joinpoints
	 * 
	 * Pointcut expressions symbols
	 * "*" is a wildcard for return types, methods, and single parameter in a parameter list
	 * ".." is a wildcard for the parameter list of a method
	 * @Before("execution(* *(..)") this will execute on all the methods
	 * @Before("execution(* draw*(..))") this one will match any method with draw in the name and one or zero parameter
	 * @Before("execution(int *aw*(..))") this one will match any method that returns an integer and has aw in the method name, with one or zero parameters
	 * @Before("execution(* *(char, int)") this one will match any method that takes in a char and int as its paramaters
	 * @Before("execution(* *aw*(..,int))") this one will match any method with aw in its name, and has 1 or 2 paremeters, the second parameter being an int
	 * @Before("execution(protected * *(..)") this one will match any method with one or zero parameters that is protected
	 */
	
	//This will create a set of joinpoints that is before the execution of any method in the program
	@Before("execution(* *(..))")
	public void printBeforeAllMethods(JoinPoint jp) {
		System.out.println("This should print before every method call");
	}
	
	//This will execute before method in the ProxyApp class that starts with draw
	@Before("execution(* com.example.myapp.ProxyApp.draw*(..))")
	public void buildEnthusiasm(JoinPoint jp) {
		System.out.println("Builing Enthusiam");
	}
	
	//This will execture before any methods that ends with an e
	@Before("execution(* *e(..))")
	public void takeABreak(JoinPoint jp) {
		System.out.println("take a break");
		System.out.println("eat and take a nap");
		System.out.println(jp.getSourceLocation());
		System.out.println(jp.getThis());
	}
	
	@Around("execution(* scul*(..))")
	public void aroundAdvice(ProceedingJoinPoint pjp) throws Throwable{
		
		//This half will act like @Before
		System.out.println("Wetting the clay");
		System.out.println(pjp.getSignature());
		
		//Everything after proceed acts as the @After
		pjp.proceed();
		
		System.out.println("cleaning the mess");
		
	}
	
	
}
