package edu.ntut.user.myhw3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    private Spinner mSpnAge;
    private RadioGroup mRadGrp;
    private RadioButton mRadBtnMale;
    private RadioButton mRadBtnFemale;
    private CheckBox mCbMusic, mCbSing, mCbDance, mCbTravel, mCbReading, mCbWriting, mCbClimbing, mCbSwim, mCbEating, mCbDrawing;
    private Button mBtnOK;
    private TextView mTxtSug, mTxtSelectedHobbies;

    private String selectedAge;
    private int ageRange;

    private ArrayAdapter<CharSequence> maleAge;
    private ArrayAdapter<CharSequence> femaleAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSpnAge = (Spinner) findViewById(R.id.spnAge);
        mRadGrp = (RadioGroup) findViewById(R.id.radGrpAge);
        mRadBtnMale = (RadioButton) findViewById(R.id.radBtnMale);
        mRadBtnFemale = (RadioButton) findViewById(R.id.radBtnFemale);
        mBtnOK = (Button) findViewById(R.id.btnOK);
        mTxtSug = (TextView) findViewById(R.id.txtSug);
        mTxtSelectedHobbies = (TextView) findViewById(R.id.txtSelectedHobbies);
        maleAge = ArrayAdapter.createFromResource(MainActivity.this, R.array.maleAge_list, R.layout.support_simple_spinner_dropdown_item);
        femaleAge = ArrayAdapter.createFromResource(MainActivity.this, R.array.femaleAge_list, R.layout.support_simple_spinner_dropdown_item);
        mSpnAge.setAdapter(maleAge);
        mSpnAge.setOnItemSelectedListener(spnOnItemSelect);
        mRadGrp.setOnCheckedChangeListener(radGrpSexOnCheckedChange);
        ageRange = 0;
        mBtnOK.setOnClickListener(btnOKOnClick);
        mTxtSelectedHobbies.setText(R.string.hobbies);

        mCbMusic = (CheckBox) findViewById(R.id.cbMusic);
        mCbSing = (CheckBox) findViewById(R.id.cbSing);
        mCbDance = (CheckBox) findViewById(R.id.cbDance);
        mCbTravel = (CheckBox) findViewById(R.id.cbTravel);
        mCbReading = (CheckBox) findViewById(R.id.cbReading);
        mCbWriting = (CheckBox) findViewById(R.id.cbWriting);
        mCbClimbing = (CheckBox) findViewById(R.id.cbClimbing);
        mCbSwim = (CheckBox) findViewById(R.id.cbSwim);
        mCbEating = (CheckBox) findViewById(R.id.cbEating);
        mCbDrawing = (CheckBox) findViewById(R.id.cbDrawing);
    }

    private RadioGroup.OnCheckedChangeListener radGrpSexOnCheckedChange = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if (i == R.id.radBtnMale) {
                mSpnAge.setAdapter(maleAge);
            } else {
                mSpnAge.setAdapter(femaleAge);
            }
        }
    };

    private AdapterView.OnItemSelectedListener spnOnItemSelect = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            selectedAge = parent.getSelectedItem().toString();

            switch (selectedAge) {
                case "小於30歲":
                    ageRange = 1;
                    break;
                case "小於28歲":
                    ageRange = 1;
                    break;
                case "30~40歲":
                    ageRange = 2;
                    break;
                case "28~35歲":
                    ageRange = 2;
                    break;
                case "大於40歲":
                    ageRange = 3;
                    break;
                case "大於35歲":
                    ageRange = 3;
                    break;
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    private View.OnClickListener btnOKOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            MarriageSuggestion ms = new MarriageSuggestion();
            String messageSug = getString(R.string.suggestion) + getString(ms.getSuggestion(ageRange));
            String messageHob = getString(R.string.hobbies) + "\n  ";
            mTxtSug.setText(messageSug);
            if (mCbMusic.isChecked()) messageHob += getString(R.string.music) + "\n  ";
            if (mCbSing.isChecked()) messageHob += getString(R.string.sing) + "\n  ";
            if (mCbDance.isChecked()) messageHob += getString(R.string.dance) + "\n  ";
            if (mCbTravel.isChecked()) messageHob += getString(R.string.travel) + "\n  ";
            if (mCbReading.isChecked()) messageHob += getString(R.string.reading) + "\n  ";
            if (mCbWriting.isChecked()) messageHob += getString(R.string.writing) + "\n  ";
            if (mCbClimbing.isChecked()) messageHob += getString(R.string.climbing) + "\n  ";
            if (mCbSwim.isChecked()) messageHob += getString(R.string.swim) + "\n  ";
            if (mCbEating.isChecked()) messageHob += getString(R.string.eating) + "\n  ";
            if (mCbDrawing.isChecked()) messageHob += getString(R.string.drawing) + "\n  ";
            mTxtSelectedHobbies.setText(messageHob);
        }
    };
}
