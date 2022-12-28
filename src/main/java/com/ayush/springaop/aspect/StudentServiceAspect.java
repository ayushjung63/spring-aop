package com.ayush.springaop.aspect;

import com.ayush.springaop.model.Student;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class StudentServiceAspect {

    @Before(value = "execution(* com.ayush.springaop.service.StudentService.*(..))")
    public void beforeAdvice(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature());
    }
}
