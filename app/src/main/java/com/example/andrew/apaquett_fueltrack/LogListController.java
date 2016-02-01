package com.example.andrew.apaquett_fueltrack;

/**
 * Created by Andrew3 on 2/1/2016.
 */
public class LogListController {

    private static LogList logs = null;

    static public LogList getLogList() {

        if (logs == null) {
            logs = new LogList();
        }
        return logs;
    }

}
