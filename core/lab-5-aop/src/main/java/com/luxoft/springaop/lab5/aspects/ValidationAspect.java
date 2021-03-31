package com.luxoft.springaop.lab5.aspects;

import com.luxoft.springaop.lab5.exeption.ValidationException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;

@Aspect
public class ValidationAspect {

    @Around("@annotation(Valid)")
    public void setterLogger(ProceedingJoinPoint thisJoinPoint) {
        Object[] methodArgs = thisJoinPoint.getArgs();

        Integer age = (Integer) methodArgs[0];

        if (age > 100) {
            throw new ValidationException("Beda!");
        }
    }

}
