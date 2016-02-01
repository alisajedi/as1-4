package com.example.andrew.apaquett_fueltrack;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Andrew3 on 2/1/2016.
 */
public class LogList {

    ArrayList<UserLog> logList = new ArrayList<UserLog>();
    protected ArrayList<Listener> listeners = null;

    int relevantLog = -1;

    // CONSTRUCTOR
    public LogList() {
        getListeners();
    }

    // LISTENER MANAGEMENT
    private ArrayList<Listener> getListeners() {
        if (listeners == null ) {
            listeners = new ArrayList<Listener>();
        }
        return listeners;
    }

    public void addListener(Listener l) {
        getListeners().add(l);
    }

    public void notifyListeners() {
        for (Listener listener : listeners) {
            listener.update();
        }
    }

    public void removeListeners(Listener l) {
        getListeners().remove(l);
    }
    // END LISTENER MANAGEMENT


    void addLog(UserLog log) {
        logList.add(log);
        notifyListeners();
    }

    int getSize() {
        return logList.size();
    }


    public Collection<UserLog> getLogs() {
        return logList;
    }






    // INCOMPLETE
    void deleteLog(UserLog log) {
        // find the log index
        // delete at that index
    }

    public UserLog getLog(int index) {
        if (index == -1) {
            return null;
        }  // ERROR
        else {
            return logList.get(index);
        }
    }

}
