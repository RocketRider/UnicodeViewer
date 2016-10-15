package com.rrsoftware.unicodeviewer;


public interface MainView {
    void showLowBits(final String code);

    void showHighBits(final String code);

    void showUnicodeSymbol(final String symbol);
}
