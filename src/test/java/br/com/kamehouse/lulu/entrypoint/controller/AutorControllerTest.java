package br.com.kamehouse.lulu.entrypoint.controller;

import br.com.kamehouse.lulu.core.usecase.AutorCriacaoUsecase;
import br.com.kamehouse.lulu.entrypoint.dto.AutorDto;
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
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class AutorControllerTest {

    @InjectMocks
    private AutorController autorController;
    @Mock
    private AutorCriacaoUsecase autorCriacaoUsecase;

    @Test
    @DisplayName("Ao acessar a rota /login deve retornar uma string com autor/login que no navegador vai abrir a página neste diretório.")
    void testLogin() {
        var response = this.autorController.login();
        Assertions.assertEquals("autor/login", response);
    }

    @Test
    @DisplayName("Ao acessar a rota /autor/novo deve retornar uma string com autor/criar_autor que no navegador vai abrir a página neste diretório.")
    void criarAutor() {
        var response = this.autorController.criarAutor();
        Assertions.assertEquals("autor/criar_autor", response);
    }

    @Test
    @DisplayName("Ao acessar a rota /autor/novo deve retornar uma string com redirect:/login que no navegador vai abrir a página neste diretório.")
    void salvarAutor() {
        Mockito.when(this.autorCriacaoUsecase.criacaoDeAutor(Mockito.any())).thenReturn(ResponseDto.of(HttpStatus.CREATED, new SiglaDto()));
        var response = this.autorController.salvarAutor(new AutorDto());
        Assertions.assertEquals("redirect:/login", response);
    }
}