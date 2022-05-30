package com.example.eksamenprogrammering2022.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class CyclingTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "cyclingTeam", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Cyclist> cyclists = new HashSet<>();

    public CyclingTeam(String name) {
        this.name = name;
    }

    public void addCyclists(Set<Cyclist> cyclists){
        this.cyclists.addAll(cyclists);
        for(Cyclist cyclist: cyclists){
            cyclist.setCyclingTeam(this);
        }
    }
}
