package br.com.kamehouse.lulu.core.usecase;

import br.com.kamehouse.lulu.core.adapter.impl.AutorAdapterImpl;
import br.com.kamehouse.lulu.core.domain.Autor;
import br.com.kamehouse.lulu.entrypoint.dto.AutorDto;
import br.com.kamehouse.lulu.entrypoint.dto.ResponseDto;
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
class AutorCriacaoUsecaseTest {

    @InjectMocks
    private AutorCriacaoUsecase autorCriacaoUsecase;
    @Mock
    private AutorAdapterImpl autorAdapterImpl;
    @Mock
    private CacheManager cacheManager;
    @Mock
    private Cache cache;

    @Test
    void testCriacaoDeAutor() {
        var autorDto = GenerateData.generateAutorDto();
        Autor autor = new Autor();
        BeanUtils.copyProperties(autorDto, autor);
        Mockito.when(this.autorAdapterImpl.salvar(Mockito.any())).thenReturn(autor);
        Mockito.when(this.cacheManager.getCache(Mockito.anyString())).thenReturn(this.cache);

        ResponseDto<AutorDto> response = this.autorCriacaoUsecase.criacaoDeAutor(autorDto);
        Assertions.assertEquals(String.valueOf(HttpStatus.CREATED.value()), response.getCode());
        System.out.println(response.getData().getSenha());
        Assertions.assertEquals("#############################", response.getData().getSenha());
        Assertions.assertEquals(autorDto.getEmail(), response.getData().getEmail());
        Assertions.assertEquals(autorDto.getNome(), response.getData().getNome());
    }
}