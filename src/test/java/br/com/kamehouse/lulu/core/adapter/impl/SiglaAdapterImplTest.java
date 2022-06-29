package br.com.kamehouse.lulu.core.adapter.impl;

import br.com.kamehouse.lulu.core.repository.SiglaRepository;
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
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@ExtendWith(SpringExtension.class)
class SiglaAdapterImplTest {

    @InjectMocks
    private SiglaAdapterImpl siglaAdapter;
    @Mock
    private SiglaRepository siglaRepository;

    @Test
    void salvar() {
        Mockito.when(this.siglaRepository.save(Mockito.any())).thenReturn(GenerateData.generateSigla());
        Assertions.assertTrue(this.siglaAdapter.salvar(GenerateData.generateSigla()).getId() >= 0);
    }

    @Test
    void recuperarSiglas() {
        Mockito.when(this.siglaRepository.findAll()).thenReturn(List.of(GenerateData.generateSigla()));
        Assertions.assertTrue(this.siglaAdapter.recuperarSiglas().size() > 0);
    }

    @Test
    void recuperarSiglaPorId() {
        Mockito.when(this.siglaRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(GenerateData.generateSigla()));
        var response = this.siglaAdapter.recuperarSiglaPorId(1000l);
        Assertions.assertTrue(Objects.isNull(response));
    }

    @Test
    void recuperarSiglaPorSigla() {
        Assertions.assertTrue(Objects.isNull(this.siglaAdapter.recuperarSiglaPorSigla("")));
    }

    @Test
    void getTotalDeSiglas() {
        Mockito.when(this.siglaRepository.count()).thenReturn(Long.valueOf(new Random().nextInt(999999)));
        Assertions.assertTrue(this.siglaAdapter.getTotalDeSiglas() >= 0);
    }

    @Test
    void getUltimaSigla() {
        Mockito.when(this.siglaRepository.ultimaSiglaCadastrada()).thenReturn(Optional.of(GenerateData.generateSigla()));
        Assertions.assertTrue(!Objects.isNull(this.siglaAdapter.getUltimaSigla()));
    }

    @Test
    void getPrimeiraSigla() {
        Mockito.when(this.siglaRepository.primeiraSiglaCadastrada()).thenReturn(Optional.of(GenerateData.generateSigla()));
        Assertions.assertTrue(!Objects.isNull(this.siglaAdapter.getPrimeiraSigla()));
    }

    @Test
    void recuperarAutorQueMaisCriouSiglas() {
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
        Mockito.when(this.siglaRepository.findAutorQueMaisCriouSiglas()).thenReturn(Optional.of(siglasPorAutor));
        Assertions.assertEquals(1000, this.siglaAdapter.recuperarAutorQueMaisCriouSiglas().getTotal());
    }
}