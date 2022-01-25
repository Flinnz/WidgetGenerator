package ru.yabujinfan.widgetgenerator.models;

import javax.persistence.*;

@Entity
@Table(name = "statistic")
public class Statistic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long totalHours;
    private Long totalMatches;
    private Long totalWins;

    public Statistic(Long totalHours, Long totalMatches, Long totalWins, Player player) {
        this.totalHours = totalHours;
        this.totalMatches = totalMatches;
        this.totalWins = totalWins;
        this.player = player;
    }

    public Statistic() {

    }

    public Long getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(Long totalHours) {
        this.totalHours = totalHours;
    }

    public Long getTotalMatches() {
        return totalMatches;
    }

    public void setTotalMatches(Long totalMatches) {
        this.totalMatches = totalMatches;
    }

    public Long getTotalWins() {
        return totalWins;
    }

    public void setTotalWins(Long totalWins) {
        this.totalWins = totalWins;
    }
    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "id")
    private Player player;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
