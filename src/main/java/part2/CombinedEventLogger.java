package part2;

import java.util.List;

/**
 * Created by vlad on 10.11.16.
 */
public class CombinedEventLogger implements EventLogger{
    List<? extends EventLogger> loggers;


    public CombinedEventLogger(List<? extends EventLogger> loggers) {
        this.loggers = loggers;
    }

    public CombinedEventLogger() {
    }

    public void logEvent(Event event) {
        for (EventLogger logger : loggers) {
            logger.logEvent(event);
        }
    }
}