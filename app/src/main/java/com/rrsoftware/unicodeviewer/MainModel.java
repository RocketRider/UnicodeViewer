package com.rrsoftware.unicodeviewer;

import android.content.Context;
import android.content.SharedPreferences;

import org.apache.commons.lang3.StringUtils;

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

    public void incrementLowHexBits() {
        setHexCode(getHexCodeAsInt() + 1);
    }

    public void decrementLowHexBits() {
        setHexCode(getHexCodeAsInt() - 1);
    }

    public void incrementHighHexBits() {
        setHexCode(getHexCodeAsInt() + (1 << 8));
    }

    public void decrementHighHexBits() {
        setHexCode(getHexCodeAsInt() - (1 << 8));
    }

    private int getHexCodeAsInt() {
        return Integer.parseInt(StringUtils.rightPad(hexCode, 4, "0"), 16);
    }

    private void setHexCode(final int code) {
        hexCode = StringUtils.right(StringUtils.leftPad(Integer.toHexString(code).toUpperCase(), 4, "0"), 4);
        updatePresenter();
    }

    private void updatePresenter() {
        presenter.showHexCode(hexCode);

        SharedPreferences.Editor editor = prefernces.edit();
        editor.putString(PREF_HEXCODE, hexCode);
        editor.apply();
    }
}