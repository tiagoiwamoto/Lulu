package br.com.kamehouse.lulu.core.usecase;

import br.com.kamehouse.lulu.core.adapter.impl.AutorAdapterImpl;
import br.com.kamehouse.lulu.core.adapter.impl.SiglaAdapterImpl;
import br.com.kamehouse.lulu.core.domain.Sigla;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SiglaRelatorioUsecase {

    private final SiglaAdapterImpl siglaAdapter;

    public Long totalDeAutoresCadastrados(){
        return this.siglaAdapter.getTotalDeSiglas();
    }

    public Sigla ultimaSiglaCadastrada(){
        return this.siglaAdapter.getUltimaSigla();
    }

    public Sigla primeiraSiglaCadastrada(){
        return this.siglaAdapter.getPrimeiraSigla();
    }
}
