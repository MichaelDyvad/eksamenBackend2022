package com.example.eksamenprogrammering2022.entity;

import com.example.eksamenprogrammering2022.dto.CyclistRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Cyclist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int age;

    private int mountainPoints;

    private int spurtPoints;

    @OneToOne()
    @JoinColumn(name="shirt_id", referencedColumnName = "id")
    private Shirt shirt;

    @ManyToOne()
    private CyclingTeam cyclingTeam;

    public Cyclist(String name, int age, int mountainPoints, int spurtPoints, Shirt shirt) {
        this.name = name;
        this.age = age;
        this.mountainPoints = mountainPoints;
        this.spurtPoints = spurtPoints;
        this.shirt = shirt;
    }

    public Cyclist(CyclistRequest body){
        this.name = body.getName();
        this.age = body.getAge();
        this.mountainPoints = body.getMountainPoints();
        this.spurtPoints = body.getSpurtPoints();
        this.shirt = body.getShirt();
        this.cyclingTeam = body.getCyclingTeam();
    }
}
