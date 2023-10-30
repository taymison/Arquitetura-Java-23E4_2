package br.edu.infnet.appsell;

import br.edu.infnet.appsell.model.domain.GiftCard;
import br.edu.infnet.appsell.model.service.GiftCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Component
@Order(3)
public class GiftCardLoader implements ApplicationRunner {
    @Autowired
    private GiftCardService giftCardService;

    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("files/giftcard.txt");
        BufferedReader reader = new BufferedReader(file);

        String line = reader.readLine();
        String[] fields;

        while (line != null) {
            fields = line.split(";");

            GiftCard giftCard = new GiftCard();

            giftCard.setDescription(fields[0].trim());
            giftCard.setCode(Integer.parseInt(fields[1].trim()));
            giftCard.setPrice(Float.parseFloat(fields[2].trim()));
            giftCard.setStock(Boolean.parseBoolean(fields[3].trim()));
            giftCard.setActivatable(Boolean.parseBoolean(fields[4].trim()));
            giftCard.setMembership(fields[5].trim());

            giftCardService.insert(giftCard);

            line = reader.readLine();
        }

        for (GiftCard giftCard: giftCardService.getAll()) {
            System.out.println("[GiftCard] " + giftCard);
        }

        reader.close();
    }
}
