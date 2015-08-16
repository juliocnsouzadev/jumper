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

    private final int velocidadeMovimento;

    private float alturaDoCanoSuperior;

    public Cano(final Tela tela, final int posicao) {
        super();
        this.random = new Random();
        this.tela = tela;
        this.posicao = posicao;
        this.posicaoOriginal = posicao;
        this.velocidadeMovimento = 2;
        reloadAlturaInferior();
        reloadAlturaSuperior();
    }


    private void reloadAlturaInferior() {
        int nextAltura = 1;
        while (nextAltura < 10) {
            nextAltura = this.random.nextInt(40);
        }
        this.alturaDoCanoInferior =
                        this.tela.getAltura() - ((this.tela.getAltura() / 100) * nextAltura);
    }

    private void reloadAlturaSuperior() {
        int nextAltura = 1;
        while (nextAltura < 10) {
            nextAltura = this.random.nextInt(50);
        }
        this.alturaDoCanoSuperior = 0 + ((this.tela.getAltura() / 100) * nextAltura);
    }

    public void desenhaNo(final Canvas canvas) {
        desenhaCanoInferiorNo(canvas);
        desenhaCanoSuperiorNo(canvas);
    }

    private void desenhaCanoInferiorNo(final Canvas canvas) {
        canvas.drawRect(this.posicao, 0, this.posicao + LARGURA_DO_CANO, this.alturaDoCanoSuperior,
                        Cores.getCorDoCano());
    }

    private void desenhaCanoSuperiorNo(final Canvas canvas) {
        canvas.drawRect(this.posicao, this.alturaDoCanoInferior, this.posicao + LARGURA_DO_CANO,
                        this.tela.getAltura(), Cores.getCorDoCano());
    }

    public void move() {
        if (this.posicao > (0 - LARGURA_DO_CANO)) {
            this.posicao -= this.velocidadeMovimento;
        }
    }


    public boolean saiuDaTela() {
        return (this.posicao) < -99;
    }


    public int getPosicao() {
        return this.posicao;
    }



}
