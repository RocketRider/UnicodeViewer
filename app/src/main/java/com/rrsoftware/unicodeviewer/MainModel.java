package com.rrsoftware.unicodeviewer;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.ColorInt;

import org.apache.commons.lang3.StringUtils;

import static android.content.Context.MODE_PRIVATE;

class MainModel implements SharedPreferences.OnSharedPreferenceChangeListener {
    private static final String PREF_KEY = "UnicodeViewer";
    private static final String PREF_HEXCODE = "HexCode";
    private static final String PREF_FONT = "Font";
    private static final String PREF_FONT_STYLE = "FontStyle";
    private static final String PREF_SIZE = "Size";
    private static final String PREF_BG_COLOR = "BGColor";
    private static final String PREF_SYMBOL_COLOR = "SymbolColor";

    private String hexCode;
    private final MainPresenter presenter;
    private final SharedPreferences preferences;


    MainModel(final MainPresenter presenter, Context context) {
        this.presenter = presenter;
        preferences = context.getSharedPreferences(PREF_KEY, MODE_PRIVATE);
        preferences.registerOnSharedPreferenceChangeListener(this);
        hexCode = preferences.getString(PREF_HEXCODE, "");
        presenter.showHexCode(hexCode);
        setStyle(preferences);
    }

    void typeKey(final String key) {
        if (hexCode.length() < 4) {
            hexCode += key;
            saveHexCode();
        }
    }

    void deleteKey() {
        if (hexCode.length() > 0) {
            hexCode = hexCode.substring(0, hexCode.length() - 1);
            saveHexCode();
        }
    }

    void incrementLowHexBits() {
        setHexCode(getHexCodeAsInt() + 1);
    }

    void decrementLowHexBits() {
        setHexCode(getHexCodeAsInt() - 1);
    }

    void incrementHighHexBits() {
        setHexCode(getHexCodeAsInt() + (1 << 8));
    }

    void decrementHighHexBits() {
        setHexCode(getHexCodeAsInt() - (1 << 8));
    }

    private int getHexCodeAsInt() {
        return Integer.parseInt(StringUtils.rightPad(hexCode, 4, "0"), 16);
    }

    private void setHexCode(final int code) {
        hexCode = StringUtils.right(StringUtils.leftPad(Integer.toHexString(code).toUpperCase(), 4, "0"), 4);
        saveHexCode();
    }

    private void saveHexCode() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(PREF_HEXCODE, hexCode);
        editor.apply();
    }

    private void setStyle(final SharedPreferences pref) {
        @ColorInt final int symbolColor = pref.getInt(PREF_SYMBOL_COLOR, Color.BLACK);
        @ColorInt final int bgColor = pref.getInt(PREF_BG_COLOR, Color.TRANSPARENT);
        final int symbolSize = pref.getInt(PREF_SIZE, 24);
        final Typeface font = Typeface.create(pref.getString(PREF_FONT, "Arial"), pref.getInt(PREF_FONT_STYLE, Typeface.NORMAL));

        presenter.setViewStyle(symbolColor, bgColor, font, symbolSize);
    }

    @Override
    public void onSharedPreferenceChanged(final SharedPreferences sharedPreferences, final String key) {
        if (key.equals(PREF_HEXCODE)) {
            presenter.showHexCode(hexCode);
        } else if (key.equals(PREF_FONT) || key.equals(PREF_SIZE) ||
                key.equals(PREF_BG_COLOR) || key.equals(PREF_SYMBOL_COLOR)) {
            setStyle(sharedPreferences);
        }
    }
}