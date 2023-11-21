package br.edu.infnet.appsell.controller;

import br.edu.infnet.appsell.model.domain.Product;
import br.edu.infnet.appsell.model.service.HardwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HardwareController {

    @Autowired
    private HardwareService hardwareService;
    @Autowired
    private AppController appController;

    @GetMapping(value = "/hardware/{id}/delete")
    public String delete(@PathVariable("id") Integer id) {
        hardwareService.delete(id);

        return "redirect:/hardware/list";
    }

    @GetMapping(value = "/hardware/search")
    public String search(Model model, String search) {

        Product product = hardwareService.search(search);

        if(product != null) {
            model.addAttribute("result", product);

            return appController.showHome(model);
        }

        return "redirect:/hardware/list";
    }
}
