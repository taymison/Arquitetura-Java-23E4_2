package br.edu.infnet.appsell.controller;

import br.edu.infnet.appsell.model.service.HardwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HardwareController {

    @Autowired
    private HardwareService hardwareService;

    @GetMapping(value = "/hardware/{id}/delete")
    public String delete(@PathVariable("id") Integer id) {
        hardwareService.delete(id);

        return "redirect:/hardware/list";
    }
}
