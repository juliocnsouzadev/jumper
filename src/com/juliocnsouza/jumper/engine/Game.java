package com.juliocnsouza.jumper.engine;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.juliocnsouza.jumper.elements.Passaro;

public class Game extends SurfaceView implements Runnable {

    private boolean isRunning;
    private final SurfaceHolder holder;
    private Passaro passaro;

    public Game(final Context context) {
        super(context);
        this.isRunning = true;
        this.holder = getHolder();
        inicializaElementos();
    }

    private void inicializaElementos() {
        this.passaro = new Passaro();
    }

    @Override
    public void run() {
        while (this.isRunning) {
            if (!this.holder.getSurface().isValid()) {
                continue;
            }
            final Canvas canvas = this.holder.lockCanvas();
            this.passaro.desenhaNo(canvas);
            this.passaro.cai();
            this.holder.unlockCanvasAndPost(canvas);
        }
    }

    public void inicia() {
        this.isRunning = true;
    }

    public void pausa() {
        this.isRunning = false;
    }

}
