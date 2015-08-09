package com.juliocnsouza.jumper.graphic;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class Tela {

    private final WindowManager ws;
    private final DisplayMetrics metrics;

    public Tela(final Context context) {
        this.ws = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        final Display display = this.ws.getDefaultDisplay();
        this.metrics = new DisplayMetrics();
        display.getMetrics(this.metrics);
    }

    public int getAltura() {
        return this.metrics.heightPixels;
    }

}
