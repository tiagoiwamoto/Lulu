package br.com.kamehouse.lulu.entrypoint.controller;

import br.com.kamehouse.lulu.core.usecase.AutorRelatorioUsecase;
import br.com.kamehouse.lulu.core.usecase.SiglaRelatorioUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Controller
@RequestMapping(path = "/")
@RequiredArgsConstructor
public class HomeController {

    private final AutorRelatorioUsecase autorRelatorioUsecase;
    private final SiglaRelatorioUsecase siglaRelatorioUsecase;

    @GetMapping
    @Cacheable
    public String index(ModelMap modelMap){
        Map<String, Object> valores = new HashMap<>();
        valores.put("totalSiglas", this.siglaRelatorioUsecase.totalDeAutoresCadastrados());
        valores.put("totalAutores", this.autorRelatorioUsecase.totalDeAutoresCadastrados());
        valores.put("sizeDatabase", new Random().nextInt(999999));
        valores.put("ultimaSiglaCadastrada", this.siglaRelatorioUsecase.ultimaSiglaCadastrada());
        valores.put("primeiraSiglaCadastrada", this.siglaRelatorioUsecase.primeiraSiglaCadastrada());
        modelMap.addAttribute("valores", valores);
        return "index";
    }

}
