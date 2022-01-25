package ru.yabujinfan.widgetgenerator.models;

import javax.persistence.*;

@Entity
@Table(name = "player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer deviceId;
    private String name;
    private Integer level;
    private Long currency;

    public Player(Integer deviceId, String name, Integer level, Long currency) {
        this.deviceId = deviceId;
        this.name = name;
        this.level = level;
        this.currency = currency;
    }

    public Player() {

    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Long getCurrency() {
        return currency;
    }

    public void setCurrency(Long currency) {
        this.currency = currency;
    }
    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "id")
    private Statistic statistic;

    public Statistic getStatistic() {
        return statistic;
    }

    public void setStatistic(Statistic statistic) {
        this.statistic = statistic;
    }
}
