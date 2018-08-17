package com.example.ps.muggle.model.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.ps.muggle.app.Constants;
import com.example.ps.muggle.app.MyApp;

import javax.inject.Inject;


public class ImplPreferenceHelper implements PreferenceHelper {

    private SharedPreferences mPreferences;

    @Inject
    public ImplPreferenceHelper() {
        mPreferences = MyApp.getInstance().getSharedPreferences(Constants.SPNAME, Context.MODE_PRIVATE);
    }

    @Override
    public boolean firstRun() {
        boolean isFirstRun = mPreferences.getBoolean("isFirstRun", true);
        if (!isFirstRun) {
            return false;
        } else {
            mPreferences.edit().putBoolean("isFirstRun", false).apply();
            return true;
        }
    }

}
