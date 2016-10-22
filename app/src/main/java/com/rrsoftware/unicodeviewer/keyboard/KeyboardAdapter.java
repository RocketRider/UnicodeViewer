package com.rrsoftware.unicodeviewer.keyboard;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

public class KeyboardAdapter extends BaseAdapter implements View.OnClickListener {
    private static final String BACK_KEY = "←";
    private static final String[] elements = new String[]{
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", BACK_KEY};

    private final KeyboardPresenter presenter;

    public KeyboardAdapter(final KeyboardPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public int getCount() {
        return elements.length;
    }

    @Override
    public Object getItem(final int position) {
        return elements[position];
    }

    @Override
    public long getItemId(final int position) {
        return 0;
    }

    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {
        Button button;
        if (convertView == null) {
            button = new Button(parent.getContext());
            button.setOnClickListener(this);
        } else {
            button = (Button) convertView;
        }

        button.setText(elements[position]);
        return button;
    }

    @Override
    public void onClick(final View v) {
        if (v instanceof Button) {
            final String buttonText = ((Button) v).getText().toString();
            if (BACK_KEY.equals(buttonText)) {
                presenter.deleteKey();
            } else {
                presenter.typeKey(buttonText);
            }
        }
    }
}
