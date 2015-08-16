package com.juliocnsouza.jumper.elements;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.juliocnsouza.jumper.graphic.Cores;
import com.juliocnsouza.jumper.graphic.Tela;

public class GameOver {

    private static final Paint VERMELHO = Cores.getCorGameOver();


    public GameOver() {}

    public void desenhaNo(final Canvas canvas, final Tela tela) {

        final float meioDaTela = tela.getAltura() / 2;
        canvas.drawText("YOU LOOSE! GAME OVER!", 50, meioDaTela, VERMELHO);
    }

}
