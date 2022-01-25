package ru.yabujinfan.widgetgenerator.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.yabujinfan.widgetgenerator.models.Player;
import ru.yabujinfan.widgetgenerator.models.Statistic;

public interface StatisticRepository extends JpaRepository<Statistic, Long> {
    @Query("FROM Statistic i where i.player = :player")
    Statistic findByPlayer(@Param("player") Player player);
}
