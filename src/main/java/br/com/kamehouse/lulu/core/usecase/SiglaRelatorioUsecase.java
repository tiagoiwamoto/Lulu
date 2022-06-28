package br.com.kamehouse.lulu.core.usecase;

import br.com.kamehouse.lulu.core.adapter.impl.SiglaAdapterImpl;
import br.com.kamehouse.lulu.core.domain.Sigla;
import br.com.kamehouse.lulu.core.repository.SiglasPorAutor;
import br.com.kamehouse.lulu.entrypoint.dto.AutorDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Objects;

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
        Sigla sigla = this.siglaAdapter.getUltimaSigla();
        if(Objects.isNull(sigla)){
            sigla = new Sigla();
        }
        return sigla;
    }

    @Cacheable("primeiraSiglaCadastrada")
    public Sigla primeiraSiglaCadastrada(){
        Sigla sigla = this.siglaAdapter.getPrimeiraSigla();
        if(Objects.isNull(sigla)){
            sigla = new Sigla();
        }
        return sigla;
    }

    @Cacheable("autorQueMaisCadastrouSiglas")
    public AutorDto autorQueMaisCadastrouSiglas(){
        SiglasPorAutor siglasPorAutor = this.siglaAdapter.recuperarAutorQueMaisCriouSiglas();
        AutorDto autorDto = new AutorDto();
        if(!Objects.isNull(siglasPorAutor)){
            BeanUtils.copyProperties(siglasPorAutor, autorDto);
        }else {
            autorDto.setTotal(0);
        }
        return autorDto;
    }
}
