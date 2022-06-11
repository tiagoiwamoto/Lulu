package br.com.kamehouse.lulu.core.usecase;

import br.com.kamehouse.lulu.core.domain.Sigla;
import br.com.kamehouse.lulu.core.repository.SiglaRepository;
import br.com.kamehouse.lulu.entrypoint.dto.SiglaDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SiglaRecuperarUsecase {

    private final SiglaRepository siglaRepository;

    public List<SiglaDto> recuperarSiglas(){
        List<Sigla> siglas = this.siglaRepository.findAll();
        List<SiglaDto> siglaDtos = siglas.stream().map(sigla -> {
            SiglaDto siglaDto = new SiglaDto();
            BeanUtils.copyProperties(sigla, siglaDto);
            return siglaDto;
        }).collect(Collectors.toList());
        return siglaDtos;
    }
}
