package com.rrsoftware.unicodeviewer.utils;

import android.graphics.Typeface;

import java.io.File;

public final class FontUtil {
    private final static String PATH = "/system/fonts";

    private FontUtil() {
        //Util class
    }

    public static String[] getAllFonts() {
        final File ff[] = new File(PATH).listFiles();
        final int numFiles = ff.length;
        final String[] fonts = new String[numFiles];
        for (int i = 0; i < numFiles; ++i) {
            fonts[i] = ff[i].getName();
        }
        return fonts;
    }

    public static Typeface loadFont(final String name) {
        try {
            return Typeface.createFromFile(PATH + '/' + name);
        } catch (Exception e) {
            return Typeface.DEFAULT;
        }
    }

}
