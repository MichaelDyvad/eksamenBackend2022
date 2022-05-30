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
    private int shirt;
    private int cyclingTeam;

    public CyclistResponse(Cyclist body){
        this.id = body.getId();
        this.name = body.getName();
        this.age = body.getAge();
        this.mountainPoints = body.getMountainPoints();
        this.spurtPoints = body.getSpurtPoints();
        this.shirt = body.getShirt().getId();
        this.cyclingTeam = body.getCyclingTeam().getId();
    }

    public static List<CyclistResponse> getCyclistFromEntity(List<Cyclist> cyclists){
        return cyclists.stream().map(cyclist -> new CyclistResponse(cyclist)).collect(Collectors.toList());
    }
}
