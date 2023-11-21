package br.edu.infnet.appsell.loader;

import br.edu.infnet.appsell.logger.FileLogger;
import br.edu.infnet.appsell.model.domain.GiftCard;
import br.edu.infnet.appsell.model.domain.Hardware;
import br.edu.infnet.appsell.model.domain.Product;
import br.edu.infnet.appsell.model.domain.Seller;
import br.edu.infnet.appsell.model.service.ProductService;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Component
@Order(1)
public class ProductLoader implements ApplicationRunner {
    @Autowired
    private ProductService productService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("files/product.txt");
        BufferedReader reader = new BufferedReader(file);

        String line = reader.readLine();
        String[] fields;
        Seller seller = new Seller();

        while (line != null) {
            fields = line.split(";");

            switch (fields[6].trim()) {
                case "H":
                    Hardware hardware = new Hardware();

                    hardware.setDescription(fields[0]);
                    hardware.setCode(Integer.parseInt(fields[1].trim()));
                    hardware.setPrice(Float.parseFloat(fields[2].trim()));
                    hardware.setStock(Boolean.parseBoolean(fields[3]));
                    hardware.setBrand(fields[4]);
                    hardware.setWarrantyMonths(Integer.parseInt(fields[5].trim()));

                    seller.setId(Integer.parseInt(fields[7].trim()));
                    hardware.setSeller(seller);

                    try {
                        productService.insert(hardware);
                    } catch (ConstraintViolationException exception) {
                        FileLogger.logException("[HARDWARE] " + hardware + " - " + exception.getMessage());
                    } catch (Exception exception) {
                        FileLogger.logException(exception.getMessage());
                    }

                    break;
                case "G":
                    GiftCard giftCard = new GiftCard();

                    giftCard.setDescription(fields[0]);
                    giftCard.setCode(Integer.parseInt(fields[1].trim()));
                    giftCard.setPrice(Float.parseFloat(fields[2].trim()));
                    giftCard.setStock(Boolean.parseBoolean(fields[3]));
                    giftCard.setActivatable(Boolean.parseBoolean(fields[4]));
                    giftCard.setMembership(fields[5]);

                    seller.setId(Integer.parseInt(fields[7].trim()));
                    giftCard.setSeller(seller);

                    try {
                        productService.insert(giftCard);
                    } catch (ConstraintViolationException exception) {
                        FileLogger.logException("[GIFTCARD] " + giftCard + " - " + exception.getMessage());
                    }

                    break;
                default:
                    break;
            }

            line = reader.readLine();
        }

        for (Product product: productService.findAll()) {
            System.out.println("[Product] " + product);
        }

        reader.close();
    }
}
