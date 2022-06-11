package br.com.kamehouse.lulu.entrypoint.controller;

import br.com.kamehouse.lulu.core.domain.UserDetailsImpl;
import br.com.kamehouse.lulu.core.usecase.SiglaCriacaoUsecase;
import br.com.kamehouse.lulu.core.usecase.SiglaRecuperarUsecase;
import br.com.kamehouse.lulu.entrypoint.dto.SiglaDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/siglas")
@RequiredArgsConstructor
public class SiglaController {

    private final SiglaCriacaoUsecase siglaCriacaoUsecase;
    private final SiglaRecuperarUsecase siglaRecuperarUsecase;

    @GetMapping
    public String index(ModelMap modelMap){
        modelMap.addAttribute("siglas", this.siglaRecuperarUsecase.recuperarSiglas());
        return "index";
    }

    @GetMapping(path = "/criar")
    public String paginaCriarSigla(ModelMap modelMap){
        return "criar_sigla";
    }

    @PostMapping(path = "/criar")
    public String criarSigla(SiglaDto siglaDto, Authentication authentication, ModelMap modelMap){
        System.out.println(siglaDto.toString());
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        siglaDto.setAutor(userDetails.getAutor());
        this.siglaCriacaoUsecase.criacaoDeSigla(siglaDto);
        return this.index(modelMap);
    }

}
