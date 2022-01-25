package ru.yabujinfan.widgetgenerator.services;

import org.springframework.stereotype.Service;
import ru.yabujinfan.widgetgenerator.models.Player;
import ru.yabujinfan.widgetgenerator.models.Statistic;
import ru.yabujinfan.widgetgenerator.repos.StatisticRepository;

@Service
public class StatisticService {
    private final StatisticRepository statisticRepository;

    public StatisticService(StatisticRepository statisticRepository) {
        this.statisticRepository = statisticRepository;
    }

    public Statistic addStatistic(Statistic statistic) {
        return statisticRepository.save(statistic);
    }

    public Statistic getStatistic(Player player) {
        return statisticRepository.findByPlayer(player);
    }
}
