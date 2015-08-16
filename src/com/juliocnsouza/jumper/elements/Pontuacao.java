package com.juliocnsouza.jumper.elements;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.juliocnsouza.jumper.graphic.Cores;

public class Pontuacao {

    private static final Paint BRANCO = Cores.getCorDaPontuacao();

    private int pontos;

    public Pontuacao() {
        this.pontos = 0;
    }

    public void desenhaNo(final Canvas canvas) {
        String pontosTxt = "pontos: " + this.pontos;
        if ((this.pontos != 0) && ((this.pontos % 10) == 0)) {
            pontosTxt = "Uhuuu!! " + pontosTxt;
        }
        canvas.drawText(pontosTxt, 50, 50, BRANCO);
    }

    public void aumenta() {
        this.pontos++;
    }
}
