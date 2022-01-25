package ru.yabujinfan.widgetgenerator.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.yabujinfan.widgetgenerator.models.Map;

import java.util.List;

public interface MapRepository extends JpaRepository<Map, Long> {
    @Query("FROM Map m where m.levelRequirement <= :level")
    List<Map> findMapGreaterThanLevel(@Param("level") Integer level);
}
