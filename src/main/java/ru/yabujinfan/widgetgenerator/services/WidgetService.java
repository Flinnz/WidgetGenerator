package ru.yabujinfan.widgetgenerator.services;

import org.springframework.stereotype.Service;
import ru.yabujinfan.widgetgenerator.models.*;
import ru.yabujinfan.widgetgenerator.widgets.MapWidget;
import ru.yabujinfan.widgetgenerator.widgets.PlayerWidget;
import ru.yabujinfan.widgetgenerator.widgets.ShopItemWidget;
import ru.yabujinfan.widgetgenerator.widgets.StatisticWidget;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WidgetService {
    private final MapService mapService;
    private final ShopItemService shopItemService;
    private final ShopSpecialOfferService shopSpecialOfferService;

    public WidgetService(MapService mapService, ShopItemService shopItemService, ShopSpecialOfferService shopSpecialOfferService) {
        this.mapService = mapService;
        this.shopItemService = shopItemService;
        this.shopSpecialOfferService = shopSpecialOfferService;
    }

    public List<ShopItemWidget> getShopItemWidgets(Player player) {
        List<ShopSpecialOffer> specials = shopSpecialOfferService.getAllSpecialOffers((long) player.getLevel());
        List<ShopItem> items = shopItemService.getAllShopItems();
        List<ShopItemWidget> widgets = specials.stream().map(w -> {
            ShopItemWidget shopItemWidget = new ShopItemWidget();
            shopItemWidget.big = true;
            shopItemWidget.name = "Специальная Акция: " + w.getShopItems().stream().map(ShopItem::getName).collect(Collectors.joining(", "));
            shopItemWidget.cost = w.getTotalCost();
            return shopItemWidget;
        }).collect(Collectors.toList());
        widgets.addAll(items.stream().map(w -> {
            ShopItemWidget shopItemWidget = new ShopItemWidget();
            shopItemWidget.name = w.getName();
            shopItemWidget.big = false;
            shopItemWidget.cost = w.getCost();
            return shopItemWidget;
        }).collect(Collectors.toList()));
        return widgets;
    }

    private StatisticWidget makeWidget(String name, Integer position, Long value) {
        StatisticWidget widget = new StatisticWidget();
        widget.name = "Количество часов";
        widget.position = position;
        widget.value = value;
        return widget;
    }

    public List<StatisticWidget> getPlayerStatisticWidgets(Player player) {
        Statistic statistic = player.getStatistic();
        StatisticWidget totalHoursWidget = makeWidget("Количество часов", 0, statistic.getTotalHours());
        StatisticWidget totalMatchesWidget = makeWidget("Количество матчей", 1, statistic.getTotalMatches());
        StatisticWidget totalWinsWidget = makeWidget("Количество побед", 2, statistic.getTotalWins());
        return Arrays.asList(totalHoursWidget, totalMatchesWidget, totalWinsWidget);
    }

    public PlayerWidget getPlayerWidget(Player player) {
        PlayerWidget playerWidget = new PlayerWidget();
        playerWidget.currency = player.getCurrency();
        playerWidget.level = player.getLevel();
        playerWidget.name = player.getName();
        return playerWidget;
    }

    public List<MapWidget> getMapWidgets(Player player) {
        List<Map> maps = mapService.getAllAvailableMaps(player);
        return maps.stream().map(m -> {
            MapWidget mapWidget = new MapWidget();
            mapWidget.name = m.getName();
            mapWidget.levelRequirements = m.getLevelRequirement();
            return mapWidget;
        }).collect(Collectors.toList());
    }
}
