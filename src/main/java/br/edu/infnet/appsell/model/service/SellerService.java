package br.edu.infnet.appsell.model.service;

import br.edu.infnet.appsell.model.domain.Seller;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class SellerService {
    private final Map<String, Seller> sellerMap = new HashMap<>();

    public void insert(Seller seller) {
        sellerMap.put(seller.getCpf(), seller);
    }

    public Collection<Seller> getAll() {
        return sellerMap.values();
    }
}
