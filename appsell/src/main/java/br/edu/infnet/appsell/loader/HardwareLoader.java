package br.edu.infnet.appsell.loader;

import br.edu.infnet.appsell.logger.FileLogger;
import br.edu.infnet.appsell.model.domain.Hardware;
import br.edu.infnet.appsell.model.domain.Seller;
import br.edu.infnet.appsell.model.service.HardwareService;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Component
@Order(2)
public class HardwareLoader implements ApplicationRunner {
    @Autowired
    private HardwareService hardwareService;

    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("files/hardware.txt");
        BufferedReader reader = new BufferedReader(file);

        String line = reader.readLine();
        String[] fields;
        Seller seller = new Seller();

        while (line != null) {
            fields = line.split(";");

            Hardware hardware = new Hardware();

            hardware.setDescription(fields[0].trim());
            hardware.setCode(Integer.parseInt(fields[1].trim()));
            hardware.setPrice(Float.parseFloat(fields[2].trim()));
            hardware.setStock(Boolean.parseBoolean(fields[3].trim()));
            hardware.setBrand(fields[4].trim());
            hardware.setWarrantyMonths(Integer.parseInt(fields[5].trim()));

            seller.setId(Integer.parseInt(fields[7].trim()));
            hardware.setSeller(seller);

            try {
                hardwareService.insert(hardware);
            } catch (ConstraintViolationException exception) {
                FileLogger.logException("[HARDWARE] " + hardware + " - " + exception.getMessage());
            }

            line = reader.readLine();
        }

        for (Hardware hardware: hardwareService.getAll()) {
            System.out.println("[Hardware] " + hardware);
        }

        reader.close();
    }
}
