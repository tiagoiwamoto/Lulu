package br.com.kamehouse.lulu.core.usecase;

import br.com.kamehouse.lulu.core.adapter.impl.AutorAdapterImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class AutorRelatorioUsecaseTest {

    @InjectMocks
    private AutorRelatorioUsecase autorRelatorioUsecase;

    @Mock
    private AutorAdapterImpl autorAdapterImpl;

    @Test
    void testTotalDeAutoresCadastrados() {

        Mockito.when(this.autorAdapterImpl.getCountOfAutor()).thenReturn(1000l);
        Assertions.assertEquals(1000l, this.autorRelatorioUsecase.totalDeAutoresCadastrados());

    }
}