package com.spartan.logger;

import java.io.IOException;

public interface Logger {
    public void log(String text);
    public void logStackTrace(Exception ex);
}
