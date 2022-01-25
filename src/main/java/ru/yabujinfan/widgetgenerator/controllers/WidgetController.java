package ru.yabujinfan.widgetgenerator.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.yabujinfan.widgetgenerator.services.PlayerService;
import ru.yabujinfan.widgetgenerator.services.WidgetService;
import ru.yabujinfan.widgetgenerator.widgets.MapWidget;
import ru.yabujinfan.widgetgenerator.widgets.PlayerWidget;
import ru.yabujinfan.widgetgenerator.widgets.ShopItemWidget;
import ru.yabujinfan.widgetgenerator.widgets.StatisticWidget;

import java.util.List;

@Controller
public class WidgetController {
    private final WidgetService widgetService;
    private final PlayerService playerService;

    public WidgetController(WidgetService widgetService, PlayerService playerService) {
        this.widgetService = widgetService;
        this.playerService = playerService;
    }

    @GetMapping("/player/{id}/shop")
    public @ResponseBody List<ShopItemWidget> getShopItems(@PathVariable(value = "id") Long id) {
        return widgetService.getShopItemWidgets(playerService.getPlayer(id));
    }

    @GetMapping("/player/{id}/maps")
    public @ResponseBody List<MapWidget> getMaps(@PathVariable(value = "id") Long id) {
        return widgetService.getMapWidgets(playerService.getPlayer(id));
    }

    @GetMapping("/player/{id}/stats")
    public @ResponseBody List<StatisticWidget> getStatisticWidgets(@PathVariable(value = "id") Long id) {
        return widgetService.getPlayerStatisticWidgets(playerService.getPlayer(id));
    }

    @GetMapping("/player/{id}")
    public @ResponseBody PlayerWidget getPlayerWidget(@PathVariable(value = "id") Long id) {
        return widgetService.getPlayerWidget(playerService.getPlayer(id));
    }
}
