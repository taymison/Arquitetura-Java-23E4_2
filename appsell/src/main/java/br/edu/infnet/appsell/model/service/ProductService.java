package br.edu.infnet.appsell.model.service;

import br.edu.infnet.appsell.model.domain.Product;
import br.edu.infnet.appsell.model.domain.Seller;
import br.edu.infnet.appsell.model.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public void insert(Product product) {
        productRepository.save(product);
    }

    public Collection<Product> findAll() {
        return (Collection<Product>) productRepository.findAll();
    }

    public Collection<Product> findAll(Seller seller) {
        return productRepository.getList(seller.getId());
    }

    public Collection<Product> findAll(Integer id) {
        return productRepository.getList(id);
    }

    public long count() {
        return productRepository.count();
    }

    public void delete(Integer id) { productRepository.deleteById(id); }

    public Product search(String code) {
        return productRepository.findByCode(Integer.parseInt(code));
    }
}
