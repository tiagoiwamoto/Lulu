package br.com.kamehouse.lulu.entrypoint.controller;

import br.com.kamehouse.lulu.core.usecase.AutorCriacaoUsecase;
import br.com.kamehouse.lulu.entrypoint.dto.AutorDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AutorController {

    private final AutorCriacaoUsecase autorCriacaoUsecase;

    @GetMapping(path = "/login")
    public String login(){
        return "autor/login";
    }

    @GetMapping(path = "/autor/novo")
    public String criarAutor(){
        return "autor/criar_autor";
    }

    @PostMapping(path = "/autor/novo")
    public String salvarAutor(AutorDto autorDto){
        this.autorCriacaoUsecase.criacaoDeAutor(autorDto);
        return "/siglas";
    }

}
