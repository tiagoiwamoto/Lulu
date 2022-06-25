package br.com.kamehouse.lulu.entrypoint.controller;

import br.com.kamehouse.lulu.core.domain.UserDetailsImpl;
import br.com.kamehouse.lulu.core.usecase.SiglaCriacaoUsecase;
import br.com.kamehouse.lulu.core.usecase.SiglaRecuperarUsecase;
import br.com.kamehouse.lulu.core.usecase.SiglaRemoverUsecase;
import br.com.kamehouse.lulu.entrypoint.dto.SiglaDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/siglas")
@RequiredArgsConstructor
public class SiglaController {

    private final SiglaCriacaoUsecase siglaCriacaoUsecase;
    private final SiglaRecuperarUsecase siglaRecuperarUsecase;
    private final SiglaRemoverUsecase siglaRemoverUsecase;

    @GetMapping
    public String index(ModelMap modelMap){
        modelMap.addAttribute("siglas", this.siglaRecuperarUsecase.recuperarSiglas());
        return "siglas";
    }

    @GetMapping(path = "/criar")
    public String paginaCriarSigla(ModelMap modelMap){
        modelMap.addAttribute("siglaDto", new SiglaDto());
        modelMap.addAttribute("botaoGravarValue", "Gravar nova sigla");
        return "formulario_sigla";
    }

    @PostMapping(path = {"/criar", "/editar"})
    public String criarSigla(@Valid SiglaDto siglaDto, BindingResult bindingResult, Authentication authentication, ModelMap modelMap){
        if(bindingResult.hasErrors()){
            modelMap.addAttribute("siglaDto", siglaDto);
            modelMap.addAttribute("botaoGravarValue", "Gravar nova sigla");
            return "formulario_sigla";
        }
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        siglaDto.setAutor(userDetails.getAutor());
        this.siglaCriacaoUsecase.criacaoDeSigla(siglaDto);
        return this.index(modelMap);
    }

    @GetMapping(path = "/editar/{id}")
    public String paginaEditarSigla(@PathVariable(name = "id") Long id, ModelMap modelMap){
        modelMap.addAttribute("siglaDto", this.siglaRecuperarUsecase.recuperarSiglaPorId(id));
        modelMap.addAttribute("botaoGravarValue", "Atualizar sigla");
        return "formulario_sigla";
    }

    @GetMapping(path = "/deletar/{id}")
    public String paginaDeletarSigla(@PathVariable(name = "id") Long id, ModelMap modelMap){
        modelMap.addAttribute("siglaDto", this.siglaRecuperarUsecase.recuperarSiglaPorId(id));
        return "deletar_sigla";
    }

    @PostMapping(path = "/deletar/{id}")
    public String deletarSigla(@PathVariable(name = "id") Long id, ModelMap modelMap){
        this.siglaRemoverUsecase.deletarSigla(id);
        return "redirect:/siglas";
    }

    @GetMapping(path = "/info/{id}")
    public String paginaInfoSigla(@PathVariable(name = "id") Long id, ModelMap modelMap){
        modelMap.addAttribute("siglaDto", this.siglaRecuperarUsecase.recuperarSiglaPorId(id));
        return "sigla_info";
    }

}
