package br.com.kamehouse.lulu.core.usecase;

import br.com.kamehouse.lulu.core.domain.Sigla;
import br.com.kamehouse.lulu.core.repository.SiglaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SiglaRemoverUsecase {

    private final SiglaRepository siglaRepository;

    public void deletarSigla(Long id){
        Optional<Sigla> optionalSigla = this.siglaRepository.findById(id);
        this.siglaRepository.delete(optionalSigla.orElseThrow());
    }

}
