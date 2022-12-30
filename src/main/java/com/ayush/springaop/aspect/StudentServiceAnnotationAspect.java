package com.ayush.springaop.aspect;

import com.ayush.springaop.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/*

        |---------------------|------------------|------------------|
        |      Aspect         =     Point cut    +  Advice          |
        |---------------------|------------------|------------------|
        |                     | Where the aspect | What code is     |
        |                     |  is applied      |  executed.       |
        |---------------------|------------------|------------------|

    -> Advise defines what needs to be apply.
    -> Joinpoint is where an Advice is apply.
    -> Pointcut is a combination of different Jointpoints.
    -> Aspect is applying an Advice at Pointcuts.
*/

@Slf4j
@Aspect
@Component
public class StudentServiceAnnotationAspect {


    @Before("@annotation(com.ayush.springaop.annotation.LogRequestData) && args(data)")
    public void logGetRequest(JoinPoint joinPoints, Object data){     /* ADVICE */
        if (data instanceof Long){
            Long studentId = Long.parseLong(String.valueOf(data));
            Signature signature = joinPoints.getSignature();
            String signatureName = signature.getName();
            log.info("-----"+signatureName+"------------------id-------"+studentId+"---------------");
        }else {
            Student student = (Student) data;
            log.info("--------"+student.getId()+"---------"+student.getFullName()+"---------------");
        }
    }
}
