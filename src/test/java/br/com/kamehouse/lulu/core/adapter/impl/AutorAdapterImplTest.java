package br.com.kamehouse.lulu.core.adapter.impl;

import br.com.kamehouse.lulu.core.repository.AutorRepository;
import br.com.kamehouse.lulu.utils.GenerateData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Random;

@ExtendWith(SpringExtension.class)
class AutorAdapterImplTest {

    @InjectMocks
    private AutorAdapterImpl autorAdapter;
    @Mock
    private AutorRepository autorRepository;

    @Test
    void salvar() {
        Mockito.when(this.autorRepository.save(Mockito.any())).thenReturn(GenerateData.generateAutor());
        var response = this.autorAdapter.salvar(GenerateData.generateAutor());
        Assertions.assertTrue(response.getId() >= 0);
    }

    @Test
    void getCountOfAutor() {
        Mockito.when(this.autorRepository.count()).thenReturn(Long.valueOf(new Random().nextInt(99999999)));
        var response = this.autorAdapter.getCountOfAutor();
        Assertions.assertTrue(response >= 0);
    }
}