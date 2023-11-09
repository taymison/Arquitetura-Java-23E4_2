package br.edu.infnet.appsell.model.repository;

import br.edu.infnet.appsell.model.domain.Seller;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends CrudRepository<Seller, Integer> {

}
