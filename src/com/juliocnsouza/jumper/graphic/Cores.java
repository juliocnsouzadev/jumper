package com.juliocnsouza.jumper.graphic;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

public class Cores {

    public static Paint getCorDoPassaro() {
        final Paint vermelho = new Paint();
        vermelho.setColor(0xFFFF0000);
        vermelho.setShadowLayer(5, 5, 5, Color.BLACK);
        return vermelho;
    }

    public static Paint getCorDoCano() {
        final Paint verde = new Paint();
        verde.setColor(0xFF00FF00);
        verde.setShadowLayer(5, 5, 5, Color.BLACK);
        return verde;
    }

    public static Paint getCorDaPontuacao() {
        final Paint branco = new Paint();
        branco.setColor(0xFFFFFFFF);
        branco.setTextSize(50);
        branco.setTypeface(Typeface.DEFAULT_BOLD);
        branco.setShadowLayer(5, 5, 5, Color.BLACK);
        return branco;
    }

}
