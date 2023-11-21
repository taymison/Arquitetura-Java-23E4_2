package br.edu.infnet.appsell.controller;

import br.edu.infnet.appsell.model.domain.Product;
import br.edu.infnet.appsell.model.domain.Seller;
import br.edu.infnet.appsell.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private AppController appController;

    @GetMapping(value = "/product/search")
    public String search(Model model, String search) {

        Product product = productService.search(search);

        if(product != null) {
            model.addAttribute("result", product);

            return appController.showHome(model);
        }

        return "redirect:/product/list";
    }

    @GetMapping(value = "/product/{id}/delete")
    public String delete(@PathVariable Integer id) {
        productService.delete(id);

        return "redirect:/product/list";
    }
}
