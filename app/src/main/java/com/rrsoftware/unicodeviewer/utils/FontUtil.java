package com.rrsoftware.unicodeviewer.utils;

import android.graphics.Typeface;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class FontUtil {
    private final static String path = "/system/fonts";

    private FontUtil() {
        //Util class
    }


    public static String[] getAllFonts() {
        final File file = new File(path);
        final File ff[] = file.listFiles();
        final List<String> fonts = new ArrayList<>(ff.length);
        for (File fontFile : ff) {
            fonts.add(fontFile.getName());
        }
        return fonts.toArray(new String[0]);
    }

    public static Typeface loadFont(final String name) {
        try {
            return Typeface.createFromFile(path + '/' + name);
        } catch (Exception e) {
            return Typeface.DEFAULT;
        }
    }

}
