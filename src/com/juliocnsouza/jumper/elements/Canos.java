package com.juliocnsouza.jumper.elements;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import android.graphics.Canvas;
import android.util.Log;

import com.juliocnsouza.jumper.graphic.Tela;

public class Canos {

    private static final int DISTANCIA_ENTRE_CANOS = 200;
    private final List<Cano> canos;
    private final Tela tela;

    public Canos(final Tela tela, final int qtdCano) {
        this.tela = tela;
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
        final ListIterator<Cano> iterator = this.canos.listIterator();
        while (iterator.hasNext()) {
            final Cano cano = iterator.next();
            cano.move();
            if (cano.saiuDaTela()) {
                Log.i("SAIU DA TELA", "" + cano.getPosicao());
                iterator.remove();
                final Cano novoCano = new Cano(this.tela, getMaximo() + DISTANCIA_ENTRE_CANOS);
                iterator.add(novoCano);

            } else {
                Log.i("NAO SAIU DA TELA", "" + cano.getPosicao());
            }
        }
    }

    private int getMaximo() {
        int maximo = 0;
        for (final Cano cano : this.canos) {
            maximo = Math.max(cano.getPosicao(), maximo);
        }
        return maximo;
    }

}
