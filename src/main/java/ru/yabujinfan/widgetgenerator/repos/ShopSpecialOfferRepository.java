package ru.yabujinfan.widgetgenerator.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.yabujinfan.widgetgenerator.models.ShopSpecialOffer;

import java.util.List;

public interface ShopSpecialOfferRepository extends JpaRepository<ShopSpecialOffer, Long> {
    @Query("FROM ShopSpecialOffer s where s.levelRequirements <= :level and s.active = true")
    List<ShopSpecialOffer> findAllAvailableOffers(@Param("level") Long level);
}
