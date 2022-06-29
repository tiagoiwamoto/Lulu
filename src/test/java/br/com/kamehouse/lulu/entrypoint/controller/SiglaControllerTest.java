package br.com.kamehouse.lulu.entrypoint.controller;

import br.com.kamehouse.lulu.core.domain.Autor;
import br.com.kamehouse.lulu.core.domain.UserDetailsImpl;
import br.com.kamehouse.lulu.core.usecase.SiglaCriacaoUsecase;
import br.com.kamehouse.lulu.core.usecase.SiglaRecuperarUsecase;
import br.com.kamehouse.lulu.core.usecase.SiglaRemoverUsecase;
import br.com.kamehouse.lulu.entrypoint.dto.ResponseDto;
import br.com.kamehouse.lulu.entrypoint.dto.SiglaDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class SiglaControllerTest {

    @InjectMocks
    private SiglaController siglaController;
    @Mock
    private SiglaCriacaoUsecase siglaCriacaoUsecase;
    @Mock
    private SiglaRecuperarUsecase siglaRecuperarUsecase;
    @Mock
    private SiglaRemoverUsecase siglaRemoverUsecase;
    @Mock
    private BindingResult bindingResult;
    @Mock
    private Authentication authentication;

    @Test
    @DisplayName("Ao acessar a rota /siglas deve ser retornada a string 'siglas' que no navegador vai abrir a página neste diretório.")
    void testIndex() {
        var response = this.siglaController.index(new ModelMap());
        Assertions.assertEquals("siglas", response);
    }

    @Test
    @DisplayName("Ao acessar a rota /criar deve ser retornada a string 'formulario_sigla' que no navegador vai abrir a página neste diretório.")
    void testPaginaCriarSigla() {
        var response = this.siglaController.paginaCriarSigla(new ModelMap());
        Assertions.assertEquals("formulario_sigla", response);
    }

    @Test
    @DisplayName("Ao acessar a rota com o verbo POST /criar com um payload válido deve ser retornada a string 'siglas' que no navegador vai abrir a página neste diretório.")
    void testCriarSigla() {
        Mockito.when(this.bindingResult.hasErrors()).thenReturn(false);
        Mockito.when(this.authentication.getPrincipal()).thenReturn(new UserDetailsImpl(new Autor()));
        Mockito.when(this.siglaCriacaoUsecase.criacaoDeSigla(Mockito.any())).thenReturn(ResponseDto.of(HttpStatus.CREATED, new SiglaDto()));
        var response = this.siglaController.criarSigla(new SiglaDto(), this.bindingResult, this.authentication, new ModelMap());
        Assertions.assertEquals("siglas", response);
    }

    @Test
    @DisplayName("Ao acessar a rota /criar com um payload inválido com o verbo POST deve ser retornada a string 'formulario_sigla' que no navegador vai abrir a página neste diretório.")
    void testCriarSiglaHasError() {
        Mockito.when(this.authentication.getPrincipal()).thenReturn(new UserDetailsImpl(new Autor()));
        Mockito.when(this.bindingResult.hasErrors()).thenReturn(true);
        var response = this.siglaController.criarSigla(new SiglaDto(), this.bindingResult, this.authentication, new ModelMap());
        Assertions.assertEquals("formulario_sigla", response);
    }

    @Test
    @DisplayName("Ao acessar a rota /editar/{id} deve ser retornada a string 'formulario_sigla' que no navegador vai abrir a página neste diretório.")
    void testPaginaEditarSigla() {
        var id = Long.valueOf(new Random().nextInt(9999));
        var response = this.siglaController.paginaEditarSigla(id, new ModelMap());
        Assertions.assertEquals("formulario_sigla", response);
    }

    @Test
    @DisplayName("Ao acessar a rota /deletar/{id} deve ser retornada a string 'deletar_sigla' que no navegador vai abrir a página neste diretório.")
    void testPaginaDeletarSigla() {
        var id = Long.valueOf(new Random().nextInt(9999));
        Mockito.when(this.siglaRecuperarUsecase.recuperarSiglaPorId(Mockito.anyLong())).thenReturn(new SiglaDto());
        var response = this.siglaController.paginaDeletarSigla(id, new ModelMap());
        Assertions.assertEquals("deletar_sigla", response);
    }

    @Test
    @DisplayName("Ao acessar a rota /deletar/{id} com o verbo POST deve ser retornada a string 'redirect:/siglas' que no navegador vai abrir a página neste diretório.")
    void testDeletarSigla() {
        var id = Long.valueOf(new Random().nextInt(9999));
        Mockito.doNothing().when(this.siglaRemoverUsecase).deletarSigla(Mockito.anyLong());
        var response = this.siglaController.deletarSigla(id, new ModelMap());
        Assertions.assertEquals("redirect:/siglas", response);
    }

    @Test
    @DisplayName("Ao acessar a rota /info/{id} deve ser retornada a string 'sigla_info' que no navegador vai abrir a página neste diretório.")
    void testPaginaInfoSigla() {
        var id = Long.valueOf(new Random().nextInt(9999));
        Mockito.when(this.siglaRecuperarUsecase.recuperarSiglaPorId(Mockito.anyLong())).thenReturn(new SiglaDto());
        var response = this.siglaController.paginaInfoSigla(id, new ModelMap());
        Assertions.assertEquals("sigla_info", response);
    }
}