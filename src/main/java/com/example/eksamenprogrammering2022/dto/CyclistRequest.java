package com.example.eksamenprogrammering2022.dto;

import com.example.eksamenprogrammering2022.entity.CyclingTeam;
import com.example.eksamenprogrammering2022.entity.Shirt;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CyclistRequest {
    String name;
    int age;
    int mountainPoints;
    int spurtPoints;
    int time;
    String country;
    Shirt shirt;
    CyclingTeam cyclingTeam;
}
