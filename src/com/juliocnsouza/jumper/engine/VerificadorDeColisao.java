package com.juliocnsouza.jumper.engine;

import com.juliocnsouza.jumper.elements.Canos;
import com.juliocnsouza.jumper.elements.Passaro;

public class VerificadorDeColisao {

    private final Passaro passaro;
    private final Canos canos;

    public VerificadorDeColisao(final Passaro passaro, final Canos canos) {
        this.passaro = passaro;
        this.canos = canos;
    }


    public boolean temColisao() {
        return this.canos.temColisaoCom(this.passaro);
    }

}
