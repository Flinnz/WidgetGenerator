package ru.yabujinfan.widgetgenerator.models;

import javax.persistence.*;

@Entity
@Table(name = "map")
public class Map {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer levelRequirement;

    public Map(String name, Integer levelRequirement) {
        this.name = name;
        this.levelRequirement = levelRequirement;
    }
    public Map() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevelRequirement() {
        return levelRequirement;
    }

    public void setLevelRequirement(Integer levelRequirement) {
        this.levelRequirement = levelRequirement;
    }
}
