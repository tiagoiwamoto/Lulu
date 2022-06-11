package br.com.kamehouse.lulu.core.adapter;

import br.com.kamehouse.lulu.core.domain.Sigla;

import java.util.List;

public interface SiglaAdapter {

    Sigla salvar(Sigla sigla);
    List<Sigla> recuperarSiglas();
    Sigla recuperarSiglaPorId(Long id);
    List<Sigla> recuperarSiglaPorSigla(String sigla);

}
