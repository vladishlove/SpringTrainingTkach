package part2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 * Created by Vlad on 11/8/2016.
 */
public class Event {
    private int id;
    private String message;
    private LocalDateTime dateTime;
    private DateTimeFormatter formatter;

    public Event() {
        super();
    }
    public Event(LocalDateTime localDateTime, DateTimeFormatter formatter) {
        Random random = new Random();
        setId(random.nextInt());
        this.formatter = formatter;
        this.dateTime = localDateTime;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", dateTime=" + formatter.format(dateTime) +
                '}';
    }

    public void setId(int ID) {
        this.id = ID;
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public DateTimeFormatter getFormatter() {
        return formatter;
    }

    public void setFormatter(DateTimeFormatter formatter) {
        this.formatter = formatter;
    }
}