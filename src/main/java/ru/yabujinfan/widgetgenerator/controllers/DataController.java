package ru.yabujinfan.widgetgenerator.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.yabujinfan.widgetgenerator.models.*;
import ru.yabujinfan.widgetgenerator.services.*;

@Controller
public class DataController {
    private final MapService mapService;
    private final PlayerService playerService;
    private final ShopItemService shopItemService;
    private final StatisticService statisticService;
    private final ShopSpecialOfferService shopSpecialOfferService;

    public DataController(MapService mapService, PlayerService playerService, ShopItemService shopItemService, StatisticService statisticService, ShopSpecialOfferService shopSpecialOfferService) {
        this.mapService = mapService;
        this.playerService = playerService;
        this.shopItemService = shopItemService;
        this.statisticService = statisticService;
        this.shopSpecialOfferService = shopSpecialOfferService;
    }

    @GetMapping("/makeData")
    public @ResponseBody Boolean makeData() {
        Player karasique = playerService.addPlayer(new Player(1, "karasique", 20, 20000L));
        statisticService.addStatistic(new Statistic(1000L, 24324L, 12222L, karasique));
        Player plusique = playerService.addPlayer(new Player(2, "plusique", 2, 200L));
        statisticService.addStatistic(new Statistic(10L, 50L, 20L, plusique));
        mapService.addMap(new Map("de_dust2", 1));
        mapService.addMap(new Map("de_inferno", 5));
        mapService.addMap(new Map("de_nuke", 10));
        mapService.addMap(new Map("de_cbble", 15));
        mapService.addMap(new Map("cs_assault", 20));
        ShopItem item1 = shopItemService.addShopItem(new ShopItem("1 Case", 50L));
        ShopItem item2 = shopItemService.addShopItem(new ShopItem("5 Case", 34L));
        ShopItem item3 = shopItemService.addShopItem(new ShopItem("3 Case", 502L));
        ShopItem item4 = shopItemService.addShopItem(new ShopItem("6 Case", 54L));
        ShopItem item5 = shopItemService.addShopItem(new ShopItem("7 Case", 66L));
        ShopItem item6 = shopItemService.addShopItem(new ShopItem("8 Case", 102L));
        ShopSpecialOffer specialOffer = shopSpecialOfferService.addShopSpecialOffer(new ShopSpecialOffer(100L, 1L, true));
        specialOffer = shopSpecialOfferService.addItemsToOffer(specialOffer, item1);
        specialOffer = shopSpecialOfferService.addItemsToOffer(specialOffer, item4);
        specialOffer = shopSpecialOfferService.addItemsToOffer(specialOffer, item5);
        ShopSpecialOffer specialOffer2 = shopSpecialOfferService.addShopSpecialOffer(new ShopSpecialOffer(150L, 5L, true));
        specialOffer = shopSpecialOfferService.addItemsToOffer(specialOffer, item2);
        specialOffer = shopSpecialOfferService.addItemsToOffer(specialOffer, item3);
        return true;
    }
}
