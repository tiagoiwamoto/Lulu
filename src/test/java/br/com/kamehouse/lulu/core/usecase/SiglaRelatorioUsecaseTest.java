package br.com.kamehouse.lulu.core.usecase;

import br.com.kamehouse.lulu.core.adapter.impl.SiglaAdapterImpl;
import br.com.kamehouse.lulu.core.domain.enums.TipoSigla;
import br.com.kamehouse.lulu.core.repository.SiglasPorAutor;
import br.com.kamehouse.lulu.utils.GenerateData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

@ExtendWith(SpringExtension.class)
class SiglaRelatorioUsecaseTest {

    @InjectMocks
    private SiglaRelatorioUsecase siglaRelatorioUsecase;
    @Mock
    private SiglaAdapterImpl siglaAdapter;

    @Test
    void testTotalDeSiglasCadastradas() {
        long value = Long.valueOf(new Random().nextInt(99999));
        Mockito.when(this.siglaAdapter.getTotalDeSiglas()).thenReturn(value);
        Assertions.assertEquals(value, this.siglaRelatorioUsecase.totalDeSiglasCadastradas());
    }

    @Test
    void testUltimaSiglaCadastrada() {
        Mockito.when(this.siglaAdapter.getUltimaSigla()).thenReturn(GenerateData.generateSigla());
        var result = this.siglaRelatorioUsecase.ultimaSiglaCadastrada();
        Assertions.assertEquals(TipoSigla.PESSOAL, result.getTipo());
    }

    @Test
    void testUltimaSiglaCadastradaFirstTime() {
        Mockito.when(this.siglaAdapter.getUltimaSigla()).thenReturn(null);
        var result = this.siglaRelatorioUsecase.ultimaSiglaCadastrada();
        Assertions.assertEquals(result.getId(), null);
    }

    @Test
    void testPrimeiraSiglaCadastrada() {
        Mockito.when(this.siglaAdapter.getPrimeiraSigla()).thenReturn(GenerateData.generateSigla());
        var result = this.siglaRelatorioUsecase.primeiraSiglaCadastrada();
        Assertions.assertEquals(TipoSigla.PESSOAL, result.getTipo());
    }

    @Test
    void testPrimeiraSiglaCadastradaFirstTime() {
        Mockito.when(this.siglaAdapter.getPrimeiraSigla()).thenReturn(null);
        var result = this.siglaRelatorioUsecase.primeiraSiglaCadastrada();
        Assertions.assertEquals(result.getId(), null);
    }

    @Test
    void testAutorQueMaisCadastrouSiglas() {
        SiglasPorAutor siglasPorAutor = new SiglasPorAutor() {
            @Override
            public Long getId() {
                return 1000l;
            }

            @Override
            public String getNome() {
                return UUID.randomUUID().toString().replaceAll("-", "").substring(0,2);
            }

            @Override
            public String getEmail() {
                return UUID.randomUUID().toString().concat("@").concat("provedor.com.br");
            }

            @Override
            public LocalDateTime getTimestamp() {
                return LocalDateTime.now();
            }

            @Override
            public Integer getTotal() {
                return 1000;
            }
        };
        Mockito.when(this.siglaAdapter.recuperarAutorQueMaisCriouSiglas()).thenReturn(siglasPorAutor);
        Assertions.assertEquals(1000, this.siglaRelatorioUsecase.autorQueMaisCadastrouSiglas().getTotal());
    }

    @Test
    void testAutorQueMaisCadastrouSiglasFirstTime() {
        Mockito.when(this.siglaAdapter.recuperarAutorQueMaisCriouSiglas()).thenReturn(null);
        Assertions.assertEquals(0, this.siglaRelatorioUsecase.autorQueMaisCadastrouSiglas().getTotal());
    }
}