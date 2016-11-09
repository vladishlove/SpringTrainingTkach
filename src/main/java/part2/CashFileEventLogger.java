package part2;

import org.apache.commons.io.FileUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vlad on 11/8/2016.
 */
public class CashFileEventLogger extends FileEventLogger {
    List<Event> cash;
    int cashSize;
    CashFileEventLogger() {}
    CashFileEventLogger(String fileName, Integer cashSize) {
        super(fileName);
        cash = new ArrayList<Event>();
        this.cashSize = cashSize;
    }
    @Override
    public void logEvent(Event event) {
        if (cash.size() == cashSize) {
            writeEventFromCash();
            cash.clear();
        }
        else {
            cash.add(event);
        }
    }

    public void destroy() {
        System.out.println("in destroy");
        if (!cash.isEmpty()) {
            writeEventFromCash();
            System.out.println("End of app");
            cash.clear();
        }
    }
    private void writeEventFromCash() {
        System.out.println("in write event from cash");
        System.out.println("cash size - " + cash.size());
        for (Event ev : cash) {
            System.out.println(ev);
            super.logEvent(ev);
        }
    }

}
