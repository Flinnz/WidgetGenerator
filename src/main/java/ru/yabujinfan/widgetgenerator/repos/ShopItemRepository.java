package ru.yabujinfan.widgetgenerator.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yabujinfan.widgetgenerator.models.ShopItem;

public interface ShopItemRepository extends JpaRepository<ShopItem, Long> {
}
