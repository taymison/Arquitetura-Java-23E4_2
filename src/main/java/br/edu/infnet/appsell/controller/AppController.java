package br.edu.infnet.appsell.controller;

import br.edu.infnet.appsell.model.service.GiftCardService;
import br.edu.infnet.appsell.model.service.HardwareService;
import br.edu.infnet.appsell.model.service.ProductService;
import br.edu.infnet.appsell.model.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @Autowired
    private SellerService sellerService;
    @Autowired
    private ProductService productService;
    @Autowired
    private GiftCardService giftCardService;
    @Autowired
    private HardwareService hardwareService;

    @GetMapping(value = "/")
    public String showHome(Model model) {

        model.addAttribute("sellerCount", sellerService.count());
        model.addAttribute("productCount", productService.count());
        model.addAttribute("giftCardCount", giftCardService.count());
        model.addAttribute("hardwareCount", hardwareService.count());

        return "home";
    }

    @GetMapping(value = "/seller/list")
    public String obterListaVendedor(Model model) {

        model.addAttribute("title", "Sellers:");
        model.addAttribute("list", sellerService.getAll());

        return showHome(model);
    }

    @GetMapping(value = "/product/list")
    public String obterListaProduto(Model model) {

        model.addAttribute("title", "Products:");
        model.addAttribute("list", productService.findAll());

        return showHome(model);
    }

    @GetMapping(value = "/giftCard/list")
    public String obterListaAlimenticio(Model model) {

        model.addAttribute("title", "Gift cards:");
        model.addAttribute("list", giftCardService.getAll());

        return showHome(model);
    }

    @GetMapping(value = "/hardware/list")
    public String obterListaEletronico(Model model) {

        model.addAttribute("title", "Hardwares:");
        model.addAttribute("list", hardwareService.getAll());

        return showHome(model);
    }
}