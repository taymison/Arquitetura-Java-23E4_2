package br.edu.infnet.appsell.model.service;

import br.edu.infnet.appsell.model.domain.Seller;
import br.edu.infnet.appsell.model.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    public void insert(Seller seller) {
        sellerRepository.save(seller);
    }

    public Collection<Seller> getAll() {
        return (Collection<Seller>) sellerRepository.findAll();
    }

    public long count() { return sellerRepository.count(); }
}
