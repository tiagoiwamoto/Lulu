package br.com.kamehouse.lulu.core.usecase;

import br.com.kamehouse.lulu.core.adapter.impl.SiglaAdapterImpl;
import br.com.kamehouse.lulu.core.domain.Sigla;
import br.com.kamehouse.lulu.core.domain.enums.TipoSigla;
import br.com.kamehouse.lulu.utils.GenerateData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class SiglaCriacaoUsecaseTest {

    @InjectMocks
    private SiglaCriacaoUsecase siglaCriacaoUsecase;
    @Mock
    private SiglaAdapterImpl siglaAdapter;
    @Mock
    private CacheManager cacheManager;
    @Mock
    private Cache cache;

    @Test
    void criacaoDeSigla() {

        Sigla sigla = new Sigla();
        BeanUtils.copyProperties(GenerateData.generateSiglaDto(), sigla);
        sigla.setId(1000l);
        Mockito.when(this.cacheManager.getCache(Mockito.anyString())).thenReturn(this.cache);
        Mockito.when(this.siglaAdapter.salvar(Mockito.any())).thenReturn(sigla);
        var response = this.siglaCriacaoUsecase.criacaoDeSigla(GenerateData.generateSiglaDto());
        Assertions.assertEquals(String.valueOf(HttpStatus.CREATED.value()), response.getCode());
        Assertions.assertEquals(TipoSigla.PESSOAL, response.getData().getTipo());

    }
}