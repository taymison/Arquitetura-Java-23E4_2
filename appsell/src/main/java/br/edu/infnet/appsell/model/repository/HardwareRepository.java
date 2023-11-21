package br.edu.infnet.appsell.model.repository;

import br.edu.infnet.appsell.model.domain.Hardware;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HardwareRepository extends CrudRepository<Hardware, Integer> {
    Hardware findByBrand(String brand);
}
