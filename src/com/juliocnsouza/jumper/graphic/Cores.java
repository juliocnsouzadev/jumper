package com.juliocnsouza.jumper.graphic;

import android.graphics.Paint;

public class Cores {

    public static Paint getCorDoPassaro() {
        final Paint vermelho = new Paint();
        vermelho.setColor(0xFFFF0000);
        return vermelho;
    }

    public static Paint getCorDoCano() {
        final Paint verde = new Paint();
        verde.setColor(0xFF00FF00);
        return verde;
    }

}
