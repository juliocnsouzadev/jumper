package com.juliocnsouza.jumper.engine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;

import com.juliocnsouza.jumper.R;
import com.juliocnsouza.jumper.elements.Canos;
import com.juliocnsouza.jumper.elements.GameOver;
import com.juliocnsouza.jumper.elements.Passaro;
import com.juliocnsouza.jumper.elements.Pontuacao;
import com.juliocnsouza.jumper.graphic.Tela;

public class Game extends SurfaceView implements Runnable, OnTouchListener {

    private boolean isRunning;
    private final SurfaceHolder holder;
    private Passaro passaro;
    private Bitmap back;
    private final Tela tela;
    private Canos canos;
    private Pontuacao pontuacao;

    public Game(final Context context) {
        super(context);
        this.tela = new Tela(context);
        this.isRunning = true;
        this.holder = getHolder();
        inicializaElementos();
        setOnTouchListener(this);
    }

    private void inicializaElementos() {
        this.pontuacao = new Pontuacao();
        this.passaro = new Passaro(this.tela);
        this.canos = new Canos(this.tela, 5, this.pontuacao);
        this.back = BitmapFactory.decodeResource(getResources(), R.drawable.background);
        Bitmap.createScaledBitmap(this.back, this.back.getWidth(), this.tela.getAltura(), false);
    }

    @Override
    public void run() {
        while (this.isRunning) {
            if (!this.holder.getSurface().isValid()) {
                continue;
            }
            final Canvas canvas = this.holder.lockCanvas();
            canvas.drawBitmap(this.back, 0, 0, null);
            this.passaro.desenhaNo(canvas);
            this.passaro.cai();
            this.canos.desenhaNo(canvas);
            this.canos.move();
            this.pontuacao.desenhaNo(canvas);
            if (new VerificadorDeColisao(this.passaro, this.canos).temColisao()) {
                this.isRunning = false;
                new GameOver().desenhaNo(canvas, this.tela);
            }
            this.holder.unlockCanvasAndPost(canvas);
        }
    }

    public void inicia() {
        this.isRunning = true;
    }

    public void pausa() {
        this.isRunning = false;
    }

    @Override
    public boolean onTouch(final View v, final MotionEvent event) {
        this.passaro.pula();
        return false;
    }



}
