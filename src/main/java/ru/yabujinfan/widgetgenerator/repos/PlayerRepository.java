package ru.yabujinfan.widgetgenerator.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yabujinfan.widgetgenerator.models.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    Player findByName(String name);
}
