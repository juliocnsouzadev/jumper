package com.juliocnsouza.jumper;

import android.app.Activity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.juliocnsouza.jumper.engine.Game;

public class MainActivity extends Activity {

    private FrameLayout container;
    private Game game;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.game = new Game(this);
        this.container = (FrameLayout) findViewById(R.id.container);
        this.container.addView(this.game);
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.game.inicia();
        new Thread(this.game).start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        this.game.pausa();
    }
}
