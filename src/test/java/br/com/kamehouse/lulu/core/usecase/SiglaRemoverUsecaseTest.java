package br.com.kamehouse.lulu.core.usecase;

import br.com.kamehouse.lulu.core.repository.SiglaRepository;
import br.com.kamehouse.lulu.utils.GenerateData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
class SiglaRemoverUsecaseTest {

    @InjectMocks
    private SiglaRemoverUsecase siglaRemoverUsecase;
    @Mock
    private SiglaRepository siglaRepository;

    @Test
    void deletarSigla() {
        Mockito.when(this.siglaRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(GenerateData.generateSigla()));
        Mockito.doNothing().when(this.siglaRepository).delete(Mockito.any());
        this.siglaRemoverUsecase.deletarSigla(1000l);
        Assertions.assertTrue(GenerateData.generateSigla().getId() > 0);
    }

}