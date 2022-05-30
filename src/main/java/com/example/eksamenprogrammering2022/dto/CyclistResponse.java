package com.example.eksamenprogrammering2022.dto;

import com.example.eksamenprogrammering2022.entity.Cyclist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
public class CyclistResponse {

    private int id;
    private String name;
    private int age;
    private int mountainPoints;
    private int spurtPoints;
    private String shirt;
    private String teamName;
    private int cyclingTeam;
    private int time;
    private String country;

    public CyclistResponse(Cyclist body){
        this.id = body.getId();
        this.name = body.getName();
        this.age = body.getAge();
        this.mountainPoints = body.getMountainPoints();
        this.spurtPoints = body.getSpurtPoints();
        this.shirt = body.getShirt().getType();
        this.teamName = body.getCyclingTeam().getName();
        this.cyclingTeam = body.getCyclingTeam().getId();
        this.time = body.getTime();
        this.country = body.getCountry();
    }

    public static List<CyclistResponse> getCyclistFromEntity(List<Cyclist> cyclists){
        return cyclists.stream().map(cyclist -> new CyclistResponse(cyclist)).collect(Collectors.toList());
    }
}
