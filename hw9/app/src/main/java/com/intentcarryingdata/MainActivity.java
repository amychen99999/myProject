package com.intentcarryingdata;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private static final int MENU_MUSIC = Menu.FIRST,
            MENU_PLAY_MUSIC = Menu.FIRST + 1,
            MENU_STOP_PLAYING_MUSIC = Menu.FIRST + 2,
            MENU_ABOUT = Menu.FIRST + 3,
            MENU_EXIT = Menu.FIRST + 4;

    private RelativeLayout mRelativeLayout;
    private Button mBtnEnter, mBtnShowList;

    private DatePicker mDatePicker;
    private Spinner mSpnMeal;
    private EditText mEditDate, mEditAmount;
    private TextView mTxtView;

    private ArrayList<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRelativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
        registerForContextMenu(mRelativeLayout);
        mTxtView = (TextView) findViewById(R.id.txtItem);
        registerForContextMenu(mTxtView);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        SubMenu subMenu = menu.addSubMenu(0, MENU_MUSIC, 0, "背景音樂")
                .setIcon(android.R.drawable.ic_media_ff);
        subMenu.add(0, MENU_PLAY_MUSIC, 0, "播放背景音樂");
        subMenu.add(0, MENU_STOP_PLAYING_MUSIC, 1, "停止播放背景音樂");
        menu.add(0, MENU_ABOUT, 1, "關於這個程式...")
                .setIcon(android.R.drawable.ic_dialog_info);
        menu.add(0, MENU_EXIT, 2, "結束")
                .setIcon(android.R.drawable.ic_menu_close_clear_cancel);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case MENU_PLAY_MUSIC:
                Intent it = new Intent(MainActivity.this, MediaPlayService.class);
                startService(it);
                return true;
            case MENU_STOP_PLAYING_MUSIC:
                it = new Intent(MainActivity.this, MediaPlayService.class);
                stopService(it);
                return true;
            case MENU_ABOUT:
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("關於這個程式")
                        .setMessage("選單範例程式")
                        .setCancelable(false)
                        .setIcon(android.R.drawable.star_big_on)
                        .setPositiveButton("確定",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        // TODO Auto-generated method stub
                                    }
                                })
                        .show();

                return true;
            case MENU_EXIT:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if (v == mRelativeLayout) {
            if (menu.size() == 0) {
                SubMenu subMenu = menu.addSubMenu(0, MENU_MUSIC, 0, "背景音樂");
                subMenu.add(0, MENU_PLAY_MUSIC, 0, "播放背景音樂");
                subMenu.add(0, MENU_STOP_PLAYING_MUSIC, 1, "停止播放背景音樂");
                menu.add(0, MENU_ABOUT, 1, "關於這個程式...");
                menu.add(0, MENU_EXIT, 2, "結束");
            }
        }
        else if (v == mTxtView) {
            menu.add(0, MENU_ABOUT, 1, "關於這個程式...");
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        onOptionsItemSelected(item);
        return super.onContextItemSelected(item);
    }
}
