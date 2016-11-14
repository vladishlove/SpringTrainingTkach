package part2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by Vlad on 11/14/2016.
 */
@Aspect
public class LoggerLimitAspect {
    private int MAX_COUNT;
    private int count;
    private EventLogger otherLogger;

    public LoggerLimitAspect(int maxCount, EventLogger logger) {
        otherLogger = logger;
        MAX_COUNT = maxCount;
    }

    @Pointcut("execution(* *.logEvent(..)) && within(part2.ConsoleEventLogger)")
    private void consoleLoggerMethods() {
    }
    @Around("consoleLoggerMethods() && args(evt)")
    public void aroundLogEvent(ProceedingJoinPoint jp,
                               Event evt) throws Throwable {

        if (count < MAX_COUNT) {
            System.out.println("ConsoleEventLogger max count is not reached. Continue...");
            count++;
            jp.proceed(new Object[] {evt});
        }
        else {
            System.out.println("ConsoleEventLogger max count is reached. Logging to " + otherLogger.
                    getClass());
            evt.setMessage(evt.getMessage()+" - REDIRECTED");
            otherLogger.logEvent(evt);
        }
    }
}