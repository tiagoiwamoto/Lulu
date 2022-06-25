package br.com.kamehouse.lulu.core.usecase;

import br.com.kamehouse.lulu.core.adapter.impl.SiglaAdapterImpl;
import br.com.kamehouse.lulu.core.domain.Sigla;
import br.com.kamehouse.lulu.core.repository.SiglasPorAutor;
import br.com.kamehouse.lulu.entrypoint.dto.AutorDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SiglaRelatorioUsecase {

    private final SiglaAdapterImpl siglaAdapter;

    @Cacheable("totalDeSiglasCadastradas")
    public Long totalDeSiglasCadastradas(){
        return this.siglaAdapter.getTotalDeSiglas();
    }

    @Cacheable("ultimaSiglaCadastrada")
    public Sigla ultimaSiglaCadastrada(){
        return this.siglaAdapter.getUltimaSigla();
    }

    @Cacheable("primeiraSiglaCadastrada")
    public Sigla primeiraSiglaCadastrada(){
        return this.siglaAdapter.getPrimeiraSigla();
    }

    @Cacheable("autorQueMaisCadastrouSiglas")
    public AutorDto autorQueMaisCadastrouSiglas(){
        SiglasPorAutor siglasPorAutor = this.siglaAdapter.recuperarAutorQueMaisCriouSiglas();
        AutorDto autorDto = new AutorDto();
        BeanUtils.copyProperties(siglasPorAutor, autorDto);
        return autorDto;
    }
}
