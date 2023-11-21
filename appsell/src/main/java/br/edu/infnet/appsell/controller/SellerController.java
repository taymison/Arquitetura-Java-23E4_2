package br.edu.infnet.appsell.controller;

import br.edu.infnet.appsell.model.domain.Seller;
import br.edu.infnet.appsell.model.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SellerController {

    @Autowired
    private SellerService sellerService;
    @Autowired
    private AppController appController;

    @GetMapping(value = "/seller/search")
    public String search(Model model, String search) {

        Seller seller = sellerService.search(search);

        if(seller != null) {
            model.addAttribute("result", seller);
            return appController.showHome(model);
        }
        return "redirect:/seller/list";
    }


    @GetMapping(value = "/seller/{id}/delete")
    public String delete(@PathVariable Integer id) {
        sellerService.delete(id);

        return "redirect:/seller/list";
    }

}
