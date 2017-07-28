package com.spartan.logger;

import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.util.Date;

public class AppLogger implements Logger{
    private String logFilePath;
    private File logFile;
    public final static boolean APPEND = true;

    public AppLogger(){
        this.logFilePath = "app.log";
        this.logFile = new File(this.logFilePath);
    }

    public void setLogFilePath(final String logFilePath){
        this.logFilePath = logFilePath;
    }

    public void read() {
        try {
            BufferedReader stream = new BufferedReader(new FileReader(this.logFile));

            String line;

            while ((line = stream.readLine()) != null)
                System.out.println(line);

            stream = null;
        } catch (IOException ex) {
            System.out.println("[-] App Logger: I can't read this file");
        }
    }

    @Override
    public void log(String text){
        try {
            Date date = new Date();
            FileWriter fileWriter = new FileWriter(this.logFile, APPEND);
            fileWriter.write("--"+date.toString()+"-- \n");
            fileWriter.write(text+"\n");
            fileWriter.close();
        }catch(IOException ex){
            System.out.println("[-] App Logger: I can't write in the log file");
        }
    }

    @Override
    public void logStackTrace(Exception ex){
        try{
            Date date = new Date();
            FileWriter fileWriter = new FileWriter(this.logFile, APPEND);
            fileWriter.write("--"+date.toString()+"-- \n");

            fileWriter.write(ex.getMessage()+" \n");

            for(StackTraceElement stackTraceElement:ex.getStackTrace())
                fileWriter.write(stackTraceElement.toString()+"\n");

            fileWriter.close();
        }catch (IOException e){
            System.out.println("[-] App Logger: I can't write the stack trace");
        }
    }
}
