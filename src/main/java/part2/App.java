package part2;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * Created by Vlad on 11/8/2016.
 */
public class App {
    static Client client;
    static Map<EventType, ? extends EventLogger> loggerMap;
    static ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

    public static EventLogger getDefaultLogger() {
        return defaultLogger;
    }

    public static void setDefaultLogger(EventLogger defaultLogger) {
        App.defaultLogger = defaultLogger;
    }

    static EventLogger defaultLogger;

    public App (Client client, EventLogger logger, Map<EventType, ? extends EventLogger> loggerMap) {
        this.client = client;
        this.defaultLogger = logger;
        this.loggerMap = loggerMap;
    }

    public App() {

    }

    public static void main(String[] args) {
        App app = ctx.getBean("app", App.class);
        app.eventLogger("Some default event for user 1");
        app.eventLogger("Some error event for user 1", EventType.ERROR);
        app.eventLogger("Some info event for user 1", EventType.INFO);
        app.eventLogger("Some error event for user 1", EventType.ERROR);
        app.eventLogger("Some default event for user 1");
        ctx.close();
    }
    public static void eventLogger(String msg, EventType eventType) {
        Event event = ctx.getBean("event", Event.class);
        String message = msg.replaceAll(String.valueOf(
                client.getId()), client.getFullName() + " Greeting: " + client.getGreeting());
        event.setMessage(message);

        if (loggerMap.containsKey(eventType)) {
            loggerMap.get(eventType).logEvent(event);
        }
        else defaultLogger.logEvent(event);
    }

    public static void eventLogger(String msg) {
        eventLogger(msg, null);
    }
}