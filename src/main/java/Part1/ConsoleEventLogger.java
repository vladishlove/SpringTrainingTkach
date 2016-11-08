package part1;

/**
 * Created by Vlad on 11/8/2016.
 */
public class ConsoleEventLogger implements EventLogger {
    public void logEvent(String msg) {
        System.out.println(msg);
    }
}
