package br.edu.infnet.appsell;

import br.edu.infnet.appsell.model.domain.GiftCard;
import br.edu.infnet.appsell.model.domain.Hardware;
import br.edu.infnet.appsell.model.domain.Product;
import br.edu.infnet.appsell.model.service.ProductService;
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

                    productService.insert(hardware);

                    break;
                case "G":
                    GiftCard giftCard = new GiftCard();

                    giftCard.setDescription(fields[0]);
                    giftCard.setCode(Integer.parseInt(fields[1].trim()));
                    giftCard.setPrice(Float.parseFloat(fields[2].trim()));
                    giftCard.setStock(Boolean.parseBoolean(fields[3]));
                    giftCard.setActivatable(Boolean.parseBoolean(fields[4]));
                    giftCard.setMembership(fields[5]);

                    productService.insert(giftCard);

                    break;
                default:
                    break;
            }

            line = reader.readLine();
        }

        for (Product product: productService.getAll()) {
            System.out.println("[Product] " + product);
        }

        reader.close();
    }
}
