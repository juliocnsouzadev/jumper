package com.juliocnsouza.jumper.elements;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import android.graphics.Canvas;

import com.juliocnsouza.jumper.graphic.Tela;

public class Canos {

    private static final int DISTANCIA_ENTRE_CANOS = 200;
    private final List<Cano> canos;
    private final Tela tela;
    private final Pontuacao pontuacao;

    public Canos(final Tela tela, final int qtdCano, final Pontuacao pontuacao) {
        this.tela = tela;
        this.pontuacao = pontuacao;
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
                iterator.remove();
                final Cano novoCano = new Cano(this.tela, getMaximo() + DISTANCIA_ENTRE_CANOS);
                iterator.add(novoCano);
                this.pontuacao.aumenta();
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

    public boolean temColisaoCom(final Passaro passaro) {
        for (final Cano cano : this.canos) {
            if (cano.temColisaoHorizontalCom(passaro) && cano.temColisaoVerticalCom(passaro)) {
                return true;
            }
        }
        return false;
    }

}
