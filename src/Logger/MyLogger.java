package Logger;

import java.io.IOException;
import java.util.Date;
import java.util.logging.*;

public class MyLogger {
    private static Logger logger = null;
    private static Handler file;
    private static final String path = "C:\\Users\\admin\\IdeaProjects\\ComplexLab\\src\\Logger\\Logging.txt";

    public MyLogger() {
        logger = Logger.getGlobal();
        System.setProperty("java.util.logging.config.file", path);

        Handler console = new ConsoleHandler();
        logger.addHandler(file);
        logger.setUseParentHandlers(false);
        console.setFormatter(new MyFormatter());
        file.setFormatter(new MyFormatter());
    }

    static {
        try {
            file = new FileHandler(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static class MyFormatter extends Formatter {
        @Override
        public String format(LogRecord record) {
            return "Date: " + new Date(record.getMillis()) + "\n" + record.getLevel() + ": " + record.getMessage() + "\n\n";
        }
    }

    public static Logger getLogger() {
        return logger;
    }
}
