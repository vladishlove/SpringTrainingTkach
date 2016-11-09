package part2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Vlad on 11/8/2016.
 */
public class App {
    static Client client;
    static EventLogger consoleEventLogger;
    static Event event;
    static ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

    public App (Client cl, EventLogger logger) {
        this.client = cl;
        this.consoleEventLogger = logger;
    }

    public App() {
    }

    public static void main(String[] args) {

        App app = ctx.getBean("app", App.class);
        app.eventLogger("Some event for user 1");
    }
    public static void eventLogger(String msg) {
        Event event = ctx.getBean("event", Event.class);
        String message = msg.replaceAll(String.valueOf(client.getId()), client.getFullName());
        event.setMessage(message);
        consoleEventLogger.logEvent(event);
    }
}