package com.example.eksamenprogrammering2022.entity;

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
    @JoinColumn(name="id")
    private Shirt shirt;

    @ManyToOne()
    private CyclingTeam cyclingTeam;
}
