package part2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by Vlad on 11/14/2016.
 */

@Aspect
public class LoggingAspect {
    @Pointcut("execution(* *.logEvent(..))")
    private void allEventMethods(){
    }

    @Before("allEventMethods()")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("BEFORE: " +
                "---------------------------------------"
                + joinPoint.getTarget().getClass()
        .getSimpleName() + " " + joinPoint.getSignature().getName());
    }
}