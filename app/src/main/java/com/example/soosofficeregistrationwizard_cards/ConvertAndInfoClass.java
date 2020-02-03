package com.example.soosofficeregistrationwizard_cards;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class ConvertAndInfoClass {

    private boolean isNightMode;

    public void isNightMode(Context context) {
        SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        isNightMode = mPrefs.getBoolean("NIGHT_MODE", false);
    }

}
