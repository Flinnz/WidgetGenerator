package ru.yabujinfan.widgetgenerator.services;

import org.springframework.stereotype.Service;
import ru.yabujinfan.widgetgenerator.models.Player;
import ru.yabujinfan.widgetgenerator.repos.PlayerRepository;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player addPlayer(Player player) {
        return playerRepository.save(player);
    }

    public Player getPlayer(Long id) {
        return playerRepository.getById(id);
    }
}
