package br.edu.infnet.appsell.loader;

import br.edu.infnet.appsell.logger.FileLogger;
import br.edu.infnet.appsell.model.domain.Address;
import br.edu.infnet.appsell.model.domain.Seller;
import br.edu.infnet.appsell.model.service.SellerService;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Component
@Order(0)
public class SellerLoader implements ApplicationRunner {

    @Autowired
    private SellerService sellerService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("files/seller.txt");
        BufferedReader reader = new BufferedReader(file);

        String line = reader.readLine();
        String[] fields;

        while (line != null) {
            fields = line.split(";");

            Seller seller = new Seller();

            seller.setName(fields[0].trim());
            seller.setCpf(fields[1].trim());
            seller.setEmail(fields[2].trim());
            seller.setAddress(new Address(fields[3].trim()));

            try {
                sellerService.insert(seller);
            } catch (ConstraintViolationException exception) {
                FileLogger.logException("[SELLER] " + seller + " - " + exception.getMessage());
            }

            line = reader.readLine();
        }

        for (Seller seller: sellerService.getAll()) {
            System.out.println("[Seller] " + seller);
        }

        reader.close();
    }
}
