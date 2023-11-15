package br.edu.infnet.appsell.controller;

import br.edu.infnet.appsell.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/product/{id}/delete")
    public String delete(@PathVariable Integer id) {
        productService.delete(id);

        return "redirect:/product/list";
    }
}
