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
        this.fileName = fileName;
    }
    public void init() throws IOException{
        this.file = new File(fileName);
    }
    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(new File(fileName), event.toString(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
