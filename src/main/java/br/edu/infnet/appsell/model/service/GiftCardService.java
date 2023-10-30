package br.edu.infnet.appsell.model.service;

import br.edu.infnet.appsell.model.domain.GiftCard;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class GiftCardService {
    private final Map<Integer, GiftCard> giftCardMap = new HashMap<>();

    public void insert(GiftCard giftCard) {
        giftCardMap.put(giftCard.getCode(), giftCard);
    }

    public Collection<GiftCard> getAll() {
        return giftCardMap.values();
    }
}
