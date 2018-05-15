package com.intentcarryingdata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private Button mBtnEnter, mBtnShowList;

    private DatePicker mDatePicker;
    private Spinner mSpnMeal;
    private EditText mEditDate, mEditAmount;

    private ArrayList<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = new ArrayList<String>();
        mSpnMeal = (Spinner)findViewById(R.id.spnMeal);
        mEditDate = (EditText)findViewById(R.id.editDate);
        mEditAmount = (EditText)findViewById(R.id.editAmount);
        mBtnEnter = (Button)findViewById(R.id.btnEnter);
        mBtnEnter.setOnClickListener(btnEnterOnClick);
        mBtnShowList = (Button)findViewById(R.id.btnShowList);
        mDatePicker = (DatePicker)findViewById(R.id.datePicker);

        mBtnShowList = (Button)findViewById(R.id.btnShowList);
        mBtnShowList.setOnClickListener(btnShowListOnClick);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        mDatePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {

            public void onDateChanged(DatePicker mDatePicker, int year, int month, int dayOfMonth) {
                Log.d("Date", "Year=" + year + " Month=" + (month + 1) + " day=" + dayOfMonth);
                String date = year + "/" + (month + 1) + "/" + dayOfMonth;
                mEditDate.setText(date);
            }
        });
    }

    private View.OnClickListener btnEnterOnClick = new View.OnClickListener() {
        public void onClick(View v) {
            data.add(getString(R.string.item) + data.size() + "         " + mEditDate.getText() + "       " + mSpnMeal.getSelectedItem().toString() + "       " + mEditAmount.getText());
            Toast.makeText(MainActivity.this, mEditAmount.getText(), Toast.LENGTH_LONG).show();
        }
    };

    private View.OnClickListener btnShowListOnClick = new View.OnClickListener() {
        public void onClick(View v) {
            Intent it = new Intent();
            it.setClass(MainActivity.this, RecordActivity.class);

            Bundle bundle = new Bundle();
            bundle.putStringArrayList("DATA", data);
            it.putExtras(bundle);

            startActivity(it);
        }
    };
}
