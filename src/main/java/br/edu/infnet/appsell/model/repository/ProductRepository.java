package br.edu.infnet.appsell.model.repository;

import br.edu.infnet.appsell.model.domain.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    @Query("from Product p where p.seller.id = :sellerId")
    Collection<Product> getList(Integer sellerId);
}
