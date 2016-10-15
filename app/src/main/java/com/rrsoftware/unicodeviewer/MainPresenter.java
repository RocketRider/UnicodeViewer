package com.rrsoftware.unicodeviewer;

import android.content.Context;

import com.rrsoftware.unicodeviewer.keyboard.KeyboardPresenter;

public class MainPresenter implements KeyboardPresenter {
    private final MainView view;
    private final MainModel model;

    public MainPresenter(final MainView view, final Context context) {
        this.view = view;
        model = new MainModel(this, context);
    }

    @Override
    public void typeKey(final String key) {
        model.typeKey(key);
    }

    @Override
    public void deleteKey() {
        model.deleteKey();
    }


    public void showHexCode(final String hexCode) {
        if (hexCode.length() > 2) {
            view.showHighBits(hexCode.substring(0, 2));
            view.showLowBits(hexCode.substring(2));
        } else {
            view.showHighBits(hexCode);
            view.showLowBits("");
        }

        if (hexCode.length() == 4) {
            final char unicode = (char) Long.parseLong(hexCode, 16);
            view.showUnicodeSymbol(Character.toString(unicode));
        } else {
            view.showUnicodeSymbol("");
        }
    }
}
