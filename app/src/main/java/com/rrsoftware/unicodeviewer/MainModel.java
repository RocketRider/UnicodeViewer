package com.rrsoftware.unicodeviewer;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class MainModel {
    private static final String PREF_KEY = "UnicodeViewer";
    private static final String PREF_HEXCODE = "hexCode";

    private String hexCode;
    final MainPresenter presenter;
    final SharedPreferences prefernces;


    public MainModel(final MainPresenter presenter, Context context) {
        this.presenter = presenter;
        prefernces = context.getSharedPreferences(PREF_KEY, MODE_PRIVATE);
        hexCode = prefernces.getString(PREF_HEXCODE, "");
        presenter.showHexCode(hexCode);
    }

    public void typeKey(final String key) {
        if (hexCode.length() < 4) {
            hexCode += key;
            updatePresenter();
        }
    }

    public void deleteKey() {
        if (hexCode.length() > 0) {
            hexCode = hexCode.substring(0, hexCode.length() - 1);
            updatePresenter();
        }
    }

    private void updatePresenter() {
        presenter.showHexCode(hexCode);

        SharedPreferences.Editor editor = prefernces.edit();
        editor.putString(PREF_HEXCODE, hexCode);
        editor.apply();
    }
}
