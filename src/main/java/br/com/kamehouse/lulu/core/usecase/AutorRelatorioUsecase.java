package br.com.kamehouse.lulu.core.usecase;

import br.com.kamehouse.lulu.core.adapter.impl.AutorAdapterImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AutorRelatorioUsecase {

    private final AutorAdapterImpl autorAdapterImpl;

    @Cacheable("totalDeAutoresCadastrados")
    public Long totalDeAutoresCadastrados(){
        return this.autorAdapterImpl.getCountOfAutor();
    }
}

