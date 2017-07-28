package com.spartan.logger;

public class LoggerSingleton {
    private final static AppLogger logger = new AppLogger();

    public static AppLogger getLogger(){
        return LoggerSingleton.logger;
    }
}
