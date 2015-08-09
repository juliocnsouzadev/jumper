package com.juliocnsouza.jumper.elements;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.juliocnsouza.jumper.graphic.Cores;

public class Passaro {

    private static final float X = 100;
    private static final float RAIO = 50;
    private static final Paint VERMELHO = Cores.getCorDoPassaro();
    private float altura;

    public Passaro() {
        this.altura = 100;
    }

    public void desenhaNo(final Canvas canvas) {
        canvas.drawCircle(X, this.altura, RAIO, VERMELHO);
    }

    public void cai() {
        this.altura += 5;
    }

    public void pula() {
        if (this.altura >= (X + 150)) {
            this.altura -= 150;
        } else {
            this.altura = 100;
        }
    }

}
