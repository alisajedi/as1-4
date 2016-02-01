package com.example.andrew.apaquett_fueltrack;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class EditViewActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        LogList logs = LogListController.getLogList();

        UserLog logBeingEdited = logs.getLog(logs.relevantLog);

        if (logBeingEdited == null) {
            logs.addLog(new UserLog());
            logs.relevantLog = 0;
            logBeingEdited = logs.getLog(0);
        }
        populateFields(logBeingEdited);
    }

    public void addLog(View v) {
        LogList logs = LogListController.getLogList();
        UserLog logBeingEdited = logs.getLog(logs.relevantLog);
        EditText et1 = (EditText) findViewById(R.id.editText1);
        EditText et2 = (EditText) findViewById(R.id.editText2);
        EditText et3 = (EditText) findViewById(R.id.editText3);
        EditText et4 = (EditText) findViewById(R.id.editText4);
        EditText et5 = (EditText) findViewById(R.id.editText5);
        EditText et6 = (EditText) findViewById(R.id.editText6);
        EditText et7 = (EditText) findViewById(R.id.editText7);
        logBeingEdited.date = Integer.parseInt(et1.getText().toString());
        logBeingEdited.station = et2.getText().toString();
        logBeingEdited.odometer = Float.parseFloat(et3.getText().toString());
        logBeingEdited.fuelType = et4.getText().toString();
        logBeingEdited.amount = Float.parseFloat(et5.getText().toString());
        logBeingEdited.unitCost = Float.parseFloat(et6.getText().toString());
        logBeingEdited.totalCost = Float.parseFloat(et7.getText().toString());
        et1.setText("");
        et2.setText("");
        et3.setText("");
        et4.setText("");
        et5.setText("");
        et6.setText("");
        et7.setText("");
    }


    public void populateFields(UserLog log) {

        if (log != null) {
            EditText editText = (EditText) findViewById(R.id.editText1);
            editText.setText(String.valueOf(log.date), TextView.BufferType.EDITABLE);
            editText = (EditText) findViewById(R.id.editText2);
            editText.setText(log.station, TextView.BufferType.EDITABLE);
            editText = (EditText) findViewById(R.id.editText3);
            editText.setText(String.valueOf(log.odometer), TextView.BufferType.EDITABLE);
            editText = (EditText) findViewById(R.id.editText4);
            editText.setText(log.fuelType, TextView.BufferType.EDITABLE);
            editText = (EditText) findViewById(R.id.editText5);
            editText.setText(String.valueOf(log.amount), TextView.BufferType.EDITABLE);
            editText = (EditText) findViewById(R.id.editText6);
            editText.setText(String.valueOf(log.unitCost), TextView.BufferType.EDITABLE);
            editText = (EditText) findViewById(R.id.editText7);
            editText.setText(String.valueOf(log.totalCost), TextView.BufferType.EDITABLE);
        }

        else {
            Toast.makeText(this, "tried to populate with nothing", Toast.LENGTH_SHORT).show();
        }
    }


//    bodyText = (EditText) findViewById(R.id.body);
//    Button saveButton = (Button) findViewById(R.id.save);
//    saveButton.setOnClickListener(new View.OnClickListener() {
//
//        public void onClick(View v) {
//            setResult(RESULT_OK);
//            String text = bodyText.getText().toString();
//            saveInFile(text, new Date(System.currentTimeMillis()));
//            finish();
//        }
//    });

//    public void addStudents(View v) {
//        Toast.makeText(this, "added students", Toast.LENGTH_SHORT).show();
//        StudentListController st = new StudentListController();
//        EditText et = (EditText) findViewById(R.id.logText);
//        String text = et.getText().toString();
//        st.bulkImport(text);
//        et.setText("");
//    }

}
