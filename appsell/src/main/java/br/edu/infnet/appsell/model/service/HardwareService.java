package br.edu.infnet.appsell.model.service;

import br.edu.infnet.appsell.model.domain.Hardware;
import br.edu.infnet.appsell.model.repository.HardwareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class HardwareService {
    @Autowired
    private HardwareRepository hardwareRepository;

    public void insert(Hardware product) {
        hardwareRepository.save(product);
    }

    public Collection<Hardware> getAll() {
        return (Collection<Hardware>) hardwareRepository.findAll();
    }

    public long count() { return hardwareRepository.count(); }

    public void delete(Integer id) { hardwareRepository.deleteById(id); }

    public Hardware search(String brand) {
        return hardwareRepository.findByBrand(brand);
    }
}
