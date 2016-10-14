package com.rrsoftware.unicodeviewer.keyboard;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

public class KeyboardAdapter extends BaseAdapter {

    private static final char[] elemtents = "0123456789ABCDEF←".toCharArray();

    @Override
    public int getCount() {
        return elemtents.length;
    }

    @Override
    public Object getItem(int position) {
        return elemtents[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Button button;
        if (convertView == null) {
            button = new Button(parent.getContext());
        } else {
            button = (Button) convertView;
        }

        button.setText(String.valueOf(elemtents[position]));
        return button;
    }
}
