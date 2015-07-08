package com.example.yangle.dateschedassist;

import android.app.DatePickerDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends ActionBarActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener {
    private TextView txtStartDate;
    private TextView txtResultDate;
    private EditText edtSkipDays;
    private Button btnCalc;

    private long startTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtStartDate= (TextView) findViewById(R.id.txt_start_date);
        txtStartDate.setOnClickListener(this);
        btnCalc = (Button) findViewById(R.id.btn_calc);
        btnCalc.setOnClickListener(this);
        txtResultDate = (TextView) findViewById(R.id.txt_result_date);
        edtSkipDays = (EditText) findViewById(R.id.edt_skip_days);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Calendar c = Calendar.getInstance();
        switch(v.getId()){
            case R.id.txt_start_date:
                new DatePickerDialog(this, this, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show();
                break;
            case R.id.btn_calc:
                int skipDays = Integer.parseInt(edtSkipDays.getText().toString());
                c.setTimeInMillis(startTime);
                c.add(Calendar.DAY_OF_MONTH, skipDays);
                txtResultDate.setText(c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH) + 1) + "-" + c.get(Calendar.DAY_OF_MONTH));
                break;
        }
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(year, monthOfYear, dayOfMonth);
        startTime = c.getTimeInMillis();
        txtStartDate.setText(year + "-" + ++monthOfYear + "-" + dayOfMonth);
    }
}
