package br.edu.infnet.appsell.controller;

import br.edu.infnet.appsell.model.domain.Info;
import br.edu.infnet.appsell.model.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InfoController {
    @Autowired
    private InfoService infoService;

    @PostMapping(value = "/info/insert")
    public String insert(Info info) {
        Info result = infoService.insert(info);

        System.out.println("Result: " + result);

        return "redirect:/";
    }
}
