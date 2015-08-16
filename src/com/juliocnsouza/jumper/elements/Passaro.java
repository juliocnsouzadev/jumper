package com.juliocnsouza.jumper.elements;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.juliocnsouza.jumper.graphic.Cores;
import com.juliocnsouza.jumper.graphic.Tela;

public class Passaro {

    private static final float X = 100;
    private static final float RAIO = 50;
    private static final Paint VERMELHO = Cores.getCorDoPassaro();
    private float altura;
    private final Tela tela;

    public Passaro(final Tela tela) {
        this.tela = tela;
        this.altura = 100;
    }

    public void desenhaNo(final Canvas canvas) {
        canvas.drawCircle(X, this.altura, RAIO, VERMELHO);
    }

    public void cai() {
        final boolean chegouNoChao = (this.altura + RAIO) > this.tela.getAltura();
        if (!chegouNoChao) {
            this.altura += 3;
        }
    }

    public void pula() {
        if ((this.altura - RAIO) > 0) {
            this.altura -= 90;
        }
    }

}
