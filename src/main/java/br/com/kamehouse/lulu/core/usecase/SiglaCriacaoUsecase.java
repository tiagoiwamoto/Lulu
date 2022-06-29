package br.com.kamehouse.lulu.core.usecase;

import br.com.kamehouse.lulu.core.adapter.impl.SiglaAdapterImpl;
import br.com.kamehouse.lulu.core.domain.Sigla;
import br.com.kamehouse.lulu.entrypoint.dto.ResponseDto;
import br.com.kamehouse.lulu.entrypoint.dto.SiglaDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.CacheManager;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class SiglaCriacaoUsecase {

    private final SiglaAdapterImpl siglaAdapter;
    private final CacheManager cacheManager;

    public ResponseDto<SiglaDto> criacaoDeSigla(SiglaDto siglaDto){
        siglaDto.setTimestamp(LocalDateTime.now());
        Sigla sigla = new Sigla();
        BeanUtils.copyProperties(siglaDto, sigla);
        Sigla siglaSalva = this.siglaAdapter.salvar(sigla);
        this.cacheManager.getCache("ultimaSiglaCadastrada").clear();
        this.cacheManager.getCache("totalDeSiglasCadastradas").clear();
        this.cacheManager.getCache("autorQueMaisCadastrouSiglas").clear();
        this.cacheManager.getCache("totalDeSiglasCadastradas").clear();
        BeanUtils.copyProperties(siglaSalva, siglaDto);
        return ResponseDto.of(HttpStatus.CREATED, siglaDto);
    }

}
