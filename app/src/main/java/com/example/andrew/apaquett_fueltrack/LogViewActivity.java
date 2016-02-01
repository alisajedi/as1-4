package com.example.andrew.apaquett_fueltrack;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

// Fails on lab machines when i enable this
//import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Map;



public class LogViewActivity extends AppCompatActivity {

    private static final String FILENAME = "file.sav";
    private EditText bodyText;
    private ListView previousLogs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_view);

    }

    @Override
    protected void onStart() {
        super.onStart();
        //loadFromFile();
        final LogList logs = new LogList();
        previousLogs = (ListView) findViewById(R.id.previousLogs);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        logs.addLog(new UserLog(1, "a", 50, "good", 5, 5, 5));
        logs.addLog(new UserLog(2, "b", 50, "bad", 5, 5, 13));
        String previous_logs = new String("");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.activity_log_view);
        previousLogs.setAdapter(adapter);

        final Collection<UserLog> students = LogListController.getLogList().getLogs();
        final ArrayList<UserLog> list = new ArrayList<UserLog>(students);
        final ArrayAdapter<UserLog> logAdapter = new ArrayAdapter<UserLog>(this, android.R.layout.simple_list_item_1, list);
        previousLogs.setAdapter(logAdapter);

        LogListController.getLogList().addListener(new Listener() {
            @Override
            public void update() {
                list.clear();
                list.addAll(students);
                logAdapter.notifyDataSetChanged();
            }
        });

    }

    // Function to open the edit screen
    public void editLogs(View v) {
        Toast.makeText(this, "Edit Logs", Toast.LENGTH_SHORT).show();

        // how to figure which log to edit?
        // int logToEdit = v.getItemID();
        int logToEdit = -1;

        LogList logs = LogListController.getLogList();
        logs.relevantLog = logToEdit;
        Intent intent = new Intent(LogViewActivity.this, EditViewActivity.class);
        startActivity(intent);
    }





///// lab computers fail if i uncomment this, not sure why
    ////// ALL FROM LONELY TWITTER
//    private void loadFromFile() {
//        try {
//
//            FileInputStream fis = openFileInput(FILENAME);
//            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
//            Gson gson = new Gson();
//
//            Type listType = new TypeToken<ArrayList<Map.Entry>>() {
//            }.getType();
//            entries = gson.fromJson(in, listType);
//
//        }  catch (FileNotFoundException e) {
//            entries = new ArrayList<Map.Entry>();
//        } catch (IOException e) {
//            throw new RuntimeException();
//        }
//    }
//
//    public void saveInFile() {
//        try {
//            FileOutputStream fos = openFileOutput(FILENAME, 0);
//            BufferedReader out = new BufferedWriter(new OutputStreamWriter(fos))
//            Gson gson = new Gson();
//            gson.toJson(entries, out);
//            out.flush();
//            fos.close();
//        } catch (FileNotFoundException e) {
//            // TODO Auto-generated catch block
//            throw new RuntimeException();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            throw new RuntimeException();
//        }
//    }
}
