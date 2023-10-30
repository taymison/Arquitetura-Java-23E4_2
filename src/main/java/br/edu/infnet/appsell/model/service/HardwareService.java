package br.edu.infnet.appsell.model.service;

import br.edu.infnet.appsell.model.domain.Hardware;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class HardwareService {
    private final Map<Integer, Hardware> hardwareMap = new HashMap<>();

    public void insert(Hardware product) {
        hardwareMap.put(product.getCode(), product);
    }

    public Collection<Hardware> getAll() {
        return hardwareMap.values();
    }
}
