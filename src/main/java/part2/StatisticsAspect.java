package part2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vlad on 11/14/2016.
 */
@Aspect
public class StatisticsAspect {
    public static Map<Class<?>, Integer> loggersStatisticMap = new HashMap<>();

    @Pointcut("execution(* *.logEvent(..))")
    private void allEventMethods(){
    }
    @Before("allEventMethods()")
    void eventStatistic(JoinPoint joinPoint) {
        Class<?> clazz = joinPoint.getTarget().getClass();
        if (loggersStatisticMap
                .containsKey(clazz)) {
            loggersStatisticMap.put(clazz,
                    loggersStatisticMap.get(clazz)+1);
        }
        else loggersStatisticMap.put(clazz, 1);
    }
}
