package br.edu.infnet.appsell.model.service;

import br.edu.infnet.appsell.clients.IAddressClient;
import br.edu.infnet.appsell.model.domain.Address;
import br.edu.infnet.appsell.model.domain.Seller;
import br.edu.infnet.appsell.model.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;
    @Autowired
    private IAddressClient addressClient;

    public void insert(Seller seller) {
        Address address = addressClient.searchCep(seller.getAddress().getCep());

        seller.setAddress(address);

        sellerRepository.save(seller);
    }

    public Collection<Seller> getAll() {
        return (Collection<Seller>) sellerRepository.findAll();
    }

    public long count() { return sellerRepository.count(); }

    public void delete(Integer id) { sellerRepository.deleteById(id); }
}
