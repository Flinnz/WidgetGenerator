package ru.yabujinfan.widgetgenerator.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "shop_item")
public class ShopItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long cost;

    public ShopItem(String name, Long cost) {
        this.name = name;
        this.cost = cost;
    }

    public ShopItem() {}

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @ManyToMany(mappedBy = "shopItems")
    private Set<ShopSpecialOffer> specialOffers = new HashSet<>();

    public Set<ShopSpecialOffer> getSpecialOffers() {
        return specialOffers;
    }

    public void setSpecialOffers(Set<ShopSpecialOffer> specialOffers) {
        this.specialOffers = specialOffers;
    }
}
