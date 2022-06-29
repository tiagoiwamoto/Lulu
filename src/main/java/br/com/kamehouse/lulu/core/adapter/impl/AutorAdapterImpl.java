package br.com.kamehouse.lulu.core.adapter.impl;

import br.com.kamehouse.lulu.core.adapter.AutorAdapter;
import br.com.kamehouse.lulu.core.domain.Autor;
import br.com.kamehouse.lulu.core.repository.AutorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AutorAdapterImpl implements AutorAdapter {

    private final AutorRepository autorRepository;

    @Override
    public Autor salvar(Autor autor) {
        return this.autorRepository.save(autor);
    }

    public Long getCountOfAutor(){
        return this.autorRepository.count();
    }

}
