package com.gameusingdynamicfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class StatisticsActivity extends AppCompatActivity{

    private EditText mEdtCountSet,
            mEdtCountPlayerWin,
            mEdtCountComWin,
            mEdtCountDraw;
    private Button mBtnBack;
    private String countSet, countPlayerWin, countComWin, countDraw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        mEdtCountSet = (EditText)findViewById(R.id.edtCountSet);
        mEdtCountPlayerWin = (EditText)findViewById(R.id.edtCountPlayerWin);
        mEdtCountComWin = (EditText)findViewById(R.id.edtCountComWin);
        mEdtCountDraw = (EditText)findViewById(R.id.edtCountDraw);
        mBtnBack = (Button)findViewById(R.id.btnBack);
        mBtnBack.setOnClickListener(btnBackOnClick);

        Intent it = this.getIntent();
        countSet = String.valueOf(it.getStringExtra("countSet"));
        countPlayerWin = String.valueOf(it.getStringExtra("countPlayerWin"));
        countComWin = String.valueOf(it.getStringExtra("countComWin"));
        countDraw = String.valueOf(it.getStringExtra("countDraw"));

        mEdtCountSet.setText(countSet);
        mEdtCountDraw.setText(countDraw);
        mEdtCountComWin.setText(countComWin);
        mEdtCountPlayerWin.setText(countPlayerWin);

    }

    private View.OnClickListener btnBackOnClick = new View.OnClickListener() {
        public void onClick(View v) {
            Intent it = new Intent();
            it.setClass(StatisticsActivity.this, MainActivity.class);
            startActivity(it);
        }
    };

}
