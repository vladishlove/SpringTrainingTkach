package part2;

import java.time.LocalDateTime;
import java.util.Random;

/**
 * Created by Vlad on 11/8/2016.
 */
public class Event {
    private int id;
    private String message;
    private LocalDateTime dateTime;

    public Event() {
        super();
    }
    public Event(String message, LocalDateTime localDateTime) {
        Random random = new Random();
        setId(random.nextInt());
        this.message = message;
        this.dateTime = localDateTime;
    }

    public void setId(int ID) {
        this.id = ID;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }

    public int getId() {
        return id;
    }
}