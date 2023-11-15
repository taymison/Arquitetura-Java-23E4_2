package br.edu.infnet.appsell.controller;

import br.edu.infnet.appsell.model.service.GiftCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class GiftCardController {

    @Autowired
    private GiftCardService giftCardService;

    @GetMapping(value = "/giftCard/{id}/delete")
    public String delete(@PathVariable("id") Integer id) {
        giftCardService.delete(id);

        return "redirect:/giftCard/list";
    }
}
