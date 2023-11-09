package br.edu.infnet.appsell.model.service;

import br.edu.infnet.appsell.model.domain.GiftCard;
import br.edu.infnet.appsell.model.repository.GiftCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class GiftCardService {
    @Autowired
    private GiftCardRepository giftCardRepository;

    public void insert(GiftCard giftCard) {
        giftCardRepository.save(giftCard);
    }

    public Collection<GiftCard> getAll() {
        return (Collection<GiftCard>) giftCardRepository.findAll();
    }

    public long count() { return giftCardRepository.count(); }
}
