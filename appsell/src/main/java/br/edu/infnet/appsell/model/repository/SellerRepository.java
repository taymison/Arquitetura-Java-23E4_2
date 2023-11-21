package br.edu.infnet.appsell.model.repository;

import br.edu.infnet.appsell.model.domain.Seller;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellerRepository extends CrudRepository<Seller, Integer> {
    Seller findByCpf(String cpf);

    List<Seller> findAll(Sort sort);
}
