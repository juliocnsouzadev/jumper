package com.juliocnsouza.jumper.elements;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Canvas;

import com.juliocnsouza.jumper.graphic.Tela;

public class Canos {

    private static final int DISTANCIA_ENTRE_CANOS = 200;
    private final List<Cano> canos;

    public Canos(final Tela tela, final int qtdCano) {
        int posicao = 400;
        this.canos = new ArrayList<Cano>();
        for (int i = 0; i < qtdCano; i++) {
            this.canos.add(new Cano(tela, posicao));
            posicao += DISTANCIA_ENTRE_CANOS;
        }
    }

    public void desenhaNo(final Canvas canvas) {
        for (final Cano cano : this.canos) {
            cano.desenhaNo(canvas);
        }
    }

    public void move() {
        for (final Cano cano : this.canos) {
            cano.move();
        }
    }

}
