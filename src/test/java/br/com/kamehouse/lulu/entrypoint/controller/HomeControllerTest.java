package br.com.kamehouse.lulu.entrypoint.controller;

import br.com.kamehouse.lulu.core.domain.Sigla;
import br.com.kamehouse.lulu.core.usecase.AutorRelatorioUsecase;
import br.com.kamehouse.lulu.core.usecase.SiglaRelatorioUsecase;
import br.com.kamehouse.lulu.entrypoint.dto.AutorDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.ui.ModelMap;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class HomeControllerTest {

    @InjectMocks
    private HomeController homeController;
    @Mock
    private AutorRelatorioUsecase autorRelatorioUsecase;
    @Mock
    private SiglaRelatorioUsecase siglaRelatorioUsecase;

    @Test
    @DisplayName("Ao acessar a rota / deve ser retornada a string 'index' que no navegador vai abrir a página neste diretório.")
    void testIndex(){
        Mockito.when(this.siglaRelatorioUsecase.totalDeSiglasCadastradas()).thenReturn(1000l);
        Mockito.when(this.autorRelatorioUsecase.totalDeAutoresCadastrados()).thenReturn(1000l);
        Mockito.when(this.siglaRelatorioUsecase.autorQueMaisCadastrouSiglas()).thenReturn(new AutorDto());
        Mockito.when(this.siglaRelatorioUsecase.ultimaSiglaCadastrada()).thenReturn(new Sigla());
        Mockito.when(this.siglaRelatorioUsecase.primeiraSiglaCadastrada()).thenReturn(new Sigla());

        var response = this.homeController.index(new ModelMap());
        Assertions.assertEquals("index", response);
    }

}