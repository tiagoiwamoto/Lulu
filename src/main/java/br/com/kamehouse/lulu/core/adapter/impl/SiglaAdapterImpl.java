package br.com.kamehouse.lulu.core.adapter.impl;

import br.com.kamehouse.lulu.core.adapter.SiglaAdapter;
import br.com.kamehouse.lulu.core.domain.Sigla;
import br.com.kamehouse.lulu.core.repository.SiglaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SiglaAdapterImpl implements SiglaAdapter {

    private final SiglaRepository siglaRepository;

    @Override
    public Sigla salvar(Sigla sigla) {
        return this.siglaRepository.save(sigla);
    }

    @Override
    public List<Sigla> recuperarSiglas() {
        return this.siglaRepository.findAll();
    }

    @Override
    public Sigla recuperarSiglaPorId(Long id) {
        return null;
    }

    @Override
    public List<Sigla> recuperarSiglaPorSigla(String sigla) {
        return null;
    }
}
