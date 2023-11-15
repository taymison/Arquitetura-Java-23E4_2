package br.edu.infnet.appsell.logger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class FileLogger {
    private static final Logger logger = Logger.getLogger(FileLogger.class.getName());

    private static void initializeLogger() throws IOException {
        FileHandler fileHandler = new FileHandler("files/logs/log.txt");

        fileHandler.setFormatter(new SimpleFormatter());

        logger.addHandler(fileHandler);
    }

    public static void logException(String message) throws IOException {
        initializeLogger();

        logger.log(Level.SEVERE, message);
    }
}
