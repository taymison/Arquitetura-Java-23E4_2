package br.edu.infnet.appsell.controller;

import br.edu.infnet.appsell.model.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SellerController {

    @Autowired
    private SellerService sellerService;


    @GetMapping(value = "/seller/{id}/delete")
    public String delete(@PathVariable Integer id) {
        sellerService.delete(id);

        return "redirect:/seller/list";
    }

}
