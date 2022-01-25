package ru.yabujinfan.widgetgenerator.services;

import org.springframework.stereotype.Service;
import ru.yabujinfan.widgetgenerator.models.Map;
import ru.yabujinfan.widgetgenerator.models.Player;
import ru.yabujinfan.widgetgenerator.repos.MapRepository;

import java.util.List;

@Service
public class MapService {
    private final MapRepository mapRepository;

    public MapService(MapRepository mapRepository) {
        this.mapRepository = mapRepository;
    }

    public Map addMap(Map map) {
        return mapRepository.save(map);
    }

    public List<Map> getAllAvailableMaps(Player player) {
        return mapRepository.findMapGreaterThanLevel(player.getLevel());
    }
}
