package com.luxoft.springaop.lab5.aspects;

import com.luxoft.springaop.lab5.exeption.ValidationException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

import java.util.logging.Logger;

@Aspect
public class ValidationLoggingAspect {

    private final static Logger LOG = Logger.getLogger(ValidationLoggingAspect.class.getName());


    @AfterThrowing(pointcut = "@annotation(Valid)", throwing = "e")
    public void validationExceptionLogger(JoinPoint joinPoint, ValidationException e) {
        String methodName = joinPoint.getSignature().getName();
        Object[] methodArgs = joinPoint.getArgs();
        StringBuilder args = new StringBuilder();
        for (Object arg : methodArgs) {
            if (args.length() > 0)
                args.append(", ");
            args.append(arg.toString());
        }
        LOG.severe("ValidationException in method " + methodName + " with args " + args);
    }

}
