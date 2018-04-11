package edu.ntut.user.myhw3;

import android.widget.RadioGroup;

/**
 * Created by user on 2018/3/20.
 */

public class MarriageSuggestion {

    public int getSuggestion(int iAgeRange) {

        switch (iAgeRange) {
            case 1:
                return R.string.sug_not_hurry;
            case 2:
                return R.string.sug_find_couple;
            case 3:
                return R.string.sug_get_married;
        }
        return 0;
    }
}
