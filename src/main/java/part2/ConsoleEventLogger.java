package part2;

/**
 * Created by Vlad on 11/8/2016.
 */
public class ConsoleEventLogger implements EventLogger {
    public ConsoleEventLogger() {
    }

    public ConsoleEventLogger(Event event) {
    }

    public void logEvent(Event event) {
        System.out.println(event);
    }
}
