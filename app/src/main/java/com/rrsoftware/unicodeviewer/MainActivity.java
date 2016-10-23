package com.rrsoftware.unicodeviewer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.TextView;

import com.rrsoftware.unicodeviewer.keyboard.KeyboardAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainView {
    @BindView(R.id.symbol)
    TextView symbol;
    @BindView(R.id.hexCode1)
    TextView hexCode1;
    @BindView(R.id.hexCode2)
    TextView hexCode2;
    @BindView(R.id.keyboard)
    GridView keyboard;
    @BindView(R.id.mainToolbar)
    Toolbar toolbar;

    MainPresenter presenter;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter = new MainPresenter(this, this);
        keyboard.setAdapter(new KeyboardAdapter(presenter));

        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        toolbar.inflateMenu(R.menu.maintoolbar);
        return true;
    }

    @Override
    public void showHighBits(final String code) {
        hexCode1.setText(code);
    }

    @Override
    public void showUnicodeSymbol(final String symbol) {
        this.symbol.setText(symbol);
    }

    @Override
    public void showLowBits(final String code) {
        hexCode2.setText(code);
    }

    @OnClick(R.id.hexCode1Up)
    public void incrementHighHexBits() {
        presenter.incrementHighHexBits();
    }

    @OnClick(R.id.hexCode1Down)
    public void decrementHighHexBits() {
        presenter.decrementHighHexBits();
    }

    @OnClick(R.id.hexCode2Up)
    public void incrementLowHexBits() {
        presenter.incrementLowHexBits();
    }

    @OnClick(R.id.hexCode2Down)
    public void decrementLowHexBits() {
        presenter.decrementLowHexBits();
    }


    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings:
                //TODO
                break;
            case R.id.about:
                new AboutDialog().show(getFragmentManager(), "About");
                break;
            case R.id.close:
                finish();
                //finish() does not kill it completely, but it is the way we are supposed to do it!
                //Not appropriate ways to kill it:
                //1) System.exit(0);
                //2) android.os.Process.killProcess(android.os.Process.myPid());
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
