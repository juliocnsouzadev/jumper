package com.juliocnsouza.jumper.elements;

import java.util.Random;

import android.graphics.Canvas;

import com.juliocnsouza.jumper.graphic.Cores;
import com.juliocnsouza.jumper.graphic.Tela;

public class Cano {

    private static final int TAMANHO_DO_CANO = 250;

    private static final int LARGURA_DO_CANO = 100;

    private final Tela tela;

    private int alturaDoCanoInferior;

    private int posicao;

    private final int posicaoOriginal;

    private final Random random;

    private int velocidadeMovimento;

    public Cano(final Tela tela, final int posicao) {
        super();
        this.random = new Random();
        this.tela = tela;
        this.posicao = posicao;
        this.posicaoOriginal = posicao;
        reloadAltura();
        reloadVelocidade();
    }

    private void reloadVelocidade() {
        int nextInt = 1;
        while (nextInt < 2) {
            nextInt = this.random.nextInt(7);
        }
        this.velocidadeMovimento = nextInt;
    }

    private void reloadAltura() {
        int nextAltura = 1;
        while (nextAltura < 10) {
            nextAltura = this.random.nextInt(40);
        }
        this.alturaDoCanoInferior =
                        this.tela.getAltura() - ((this.tela.getAltura() / 100) * nextAltura);
    }

    public void desenhaNo(final Canvas canvas) {
        desenhaCanoInferiorNo(canvas);
    }

    private void desenhaCanoInferiorNo(final Canvas canvas) {
        canvas.drawRect(this.posicao, this.alturaDoCanoInferior, this.posicao + LARGURA_DO_CANO,
                        this.tela.getAltura(), Cores.getCorDoCano());
    }

    public void move() {
        if (this.posicao > (0 - LARGURA_DO_CANO)) {

            this.posicao -= this.velocidadeMovimento;
        } else {
            this.posicao = this.posicaoOriginal;
            reloadAltura();
            reloadVelocidade();
        }
    }



}
