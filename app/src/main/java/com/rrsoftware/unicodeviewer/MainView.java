package com.rrsoftware.unicodeviewer;

import android.graphics.Typeface;
import android.support.annotation.ColorInt;

public interface MainView {
    void showLowBits(final String code);

    void showHighBits(final String code);

    void showUnicodeSymbol(final String symbol);

    void setSymbolColor(@ColorInt final int color);

    void setSymbolBGColor(@ColorInt final int color);

    void setSymbolFont(final Typeface font);

    void setSymbolSize(final float size);
}