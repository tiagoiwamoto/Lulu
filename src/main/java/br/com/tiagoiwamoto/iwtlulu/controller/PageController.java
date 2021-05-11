package br.com.tiagoiwamoto.iwtlulu.controller;

/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 05/05/2021 | 21:01
 */

import br.com.tiagoiwamoto.iwtlulu.business.object.MedicationBO;
import br.com.tiagoiwamoto.iwtlulu.business.object.UserBO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

    private final UserBO userBO;
    private final MedicationBO medicationBO;

    public PageController(UserBO userBO, MedicationBO medicationBO) {
        this.userBO = userBO;
        this.medicationBO = medicationBO;
    }

    @GetMapping(path = "/")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

}
