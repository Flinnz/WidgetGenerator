package ru.yabujinfan.widgetgenerator.services;

import org.springframework.stereotype.Service;
import ru.yabujinfan.widgetgenerator.models.ShopItem;
import ru.yabujinfan.widgetgenerator.models.ShopSpecialOffer;
import ru.yabujinfan.widgetgenerator.repos.ShopSpecialOfferRepository;

import java.util.List;

@Service
public class ShopSpecialOfferService {
    private final ShopSpecialOfferRepository shopSpecialOfferRepository;

    public ShopSpecialOfferService(ShopSpecialOfferRepository shopSpecialOfferRepository) {
        this.shopSpecialOfferRepository = shopSpecialOfferRepository;
    }

    public ShopSpecialOffer addShopSpecialOffer(ShopSpecialOffer shopSpecialOffer) {
        return shopSpecialOfferRepository.save(shopSpecialOffer);
    }

    public ShopSpecialOffer addItemsToOffer(ShopSpecialOffer shopSpecialOffer, ShopItem shopItem) {
        shopSpecialOffer.getShopItems().add(shopItem);
        return shopSpecialOfferRepository.save(shopSpecialOffer);
    }

    public List<ShopSpecialOffer> getAllSpecialOffers(Long level) {
        return shopSpecialOfferRepository.findAllAvailableOffers(level);
    }
}
