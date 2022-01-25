package ru.yabujinfan.widgetgenerator.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "offer")
public class ShopSpecialOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long totalCost;

    private Long levelRequirements;

    private Boolean active;

    @ManyToMany
    @JoinTable(name="shop_special_item", joinColumns = @JoinColumn(name="item_id"), inverseJoinColumns = @JoinColumn(name="special_id"))
    private Set<ShopItem> shopItems = new HashSet<>();

    public ShopSpecialOffer(Long totalCost, Long levelRequirements, Boolean active) {
        this.totalCost = totalCost;
        this.levelRequirements = levelRequirements;
        this.active = active;
    }

    public ShopSpecialOffer() {}

    public Long getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Long totalCost) {
        this.totalCost = totalCost;
    }

    public Long getLevelRequirements() {
        return levelRequirements;
    }

    public void setLevelRequirements(Long levelRequirements) {
        this.levelRequirements = levelRequirements;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Set<ShopItem> getShopItems() {
        return shopItems;
    }

    public void setShopItems(Set<ShopItem> shopItems) {
        this.shopItems = shopItems;
    }
}
