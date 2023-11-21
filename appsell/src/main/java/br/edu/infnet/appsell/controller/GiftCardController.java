package br.edu.infnet.appsell.controller;

import br.edu.infnet.appsell.model.domain.Product;
import br.edu.infnet.appsell.model.service.GiftCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class GiftCardController {

    @Autowired
    private GiftCardService giftCardService;
    @Autowired
    private AppController appController;

    @GetMapping(value = "/giftCard/{id}/delete")
    public String delete(@PathVariable("id") Integer id) {
        giftCardService.delete(id);

        return "redirect:/giftCard/list";
    }

    @GetMapping(value = "/giftCard/search")
    public String search(Model model, String search) {

        Product product = giftCardService.search(search);

        if(product != null) {
            model.addAttribute("result", product);

            return appController.showHome(model);
        }

        return "redirect:/giftCard/list";
    }
}
