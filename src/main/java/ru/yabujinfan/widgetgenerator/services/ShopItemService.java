package ru.yabujinfan.widgetgenerator.services;

import org.springframework.stereotype.Service;
import ru.yabujinfan.widgetgenerator.models.ShopItem;
import ru.yabujinfan.widgetgenerator.repos.ShopItemRepository;

import java.util.List;

@Service
public class ShopItemService {
    private final ShopItemRepository shopItemRepository;

    public ShopItemService(ShopItemRepository shopItemRepository) {
        this.shopItemRepository = shopItemRepository;
    }

    public ShopItem addShopItem(ShopItem shopItem) {
        return shopItemRepository.save(shopItem);
    }

    public List<ShopItem> getAllShopItems() {
        return shopItemRepository.findAll();
    }
}
