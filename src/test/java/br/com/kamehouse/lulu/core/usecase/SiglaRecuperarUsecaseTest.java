package br.com.kamehouse.lulu.core.usecase;

import br.com.kamehouse.lulu.core.domain.Sigla;
import br.com.kamehouse.lulu.core.domain.enums.TipoSigla;
import br.com.kamehouse.lulu.core.repository.SiglaRepository;
import br.com.kamehouse.lulu.utils.GenerateData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
class SiglaRecuperarUsecaseTest {

    @InjectMocks
    private SiglaRecuperarUsecase siglaRecuperarUsecase;
    @Mock
    private SiglaRepository siglaRepository;

    @Test
    void testRecuperarSiglas() {
        List<Sigla> siglas = new ArrayList<>();
        for(int x = 0; x < 100; x++){
            siglas.add(GenerateData.generateSigla());
        }

        Mockito.when(this.siglaRepository.findAll()).thenReturn(siglas);
        var response = this.siglaRecuperarUsecase.recuperarSiglas();
        Assertions.assertEquals(100, response.size());
    }

    @Test
    void testRecuperarSiglaPorId() {
        Mockito.when(this.siglaRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(GenerateData.generateSigla()));
        var response = this.siglaRecuperarUsecase.recuperarSiglaPorId(1000l);
        Assertions.assertEquals(TipoSigla.PESSOAL, response.getTipo());
    }
}