package br.edu.infnet.appsell.model.service;

import br.edu.infnet.appsell.model.domain.Product;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ProductService {
    private final Map<Integer, Product> productMap = new HashMap<>();

    public void insert(Product product) {
        productMap.put(product.getCode(), product);
    }

    public Collection<Product> getAll() {
        return productMap.values();
    }
}
