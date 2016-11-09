package part2;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by Vlad on 11/8/2016.
 */
public class FileEventLogger implements EventLogger {
    String fileName;
    File file;
    public FileEventLogger () {}
    public FileEventLogger (String fileName) {
        System.out.println("in constructor of "+ this.getClass().getName());
        this.fileName = fileName;
    }
    public void init() throws IOException{
        System.out.println("in init method of " + this.getClass().getName());
        this.file = new File(fileName);
        if (!file.canWrite()) throw new IOException();
    }
    public void logEvent(Event event) {
        System.out.println("in log event method");
        try {
            FileUtils.writeStringToFile(new File(fileName),
                    event.toString()+System.lineSeparator(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
