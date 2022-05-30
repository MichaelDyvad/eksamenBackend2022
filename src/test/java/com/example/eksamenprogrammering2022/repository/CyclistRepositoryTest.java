package com.example.eksamenprogrammering2022.repository;

import com.example.eksamenprogrammering2022.entity.CyclingTeam;
import com.example.eksamenprogrammering2022.entity.Cyclist;
import com.example.eksamenprogrammering2022.entity.Shirt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CyclistRepositoryTest {

    @Autowired
    CyclistRepository cyclistRepository;
    @Autowired
    CyclingTeamRepository cyclingTeamRepository;
    @Autowired
    ShirtRepository shirtRepository;


    @BeforeEach
    void setUp() {
        cyclingTeamRepository.deleteAll();
        cyclistRepository.deleteAll();
        shirtRepository.deleteAll();

        CyclingTeam cyclingTeam1 = new CyclingTeam("Des ames");

        Shirt noShirt = new Shirt("noshirt");
        shirtRepository.save(noShirt);
        Cyclist cyclist1 = new Cyclist("FERRON Valentin", 26, 20, 15, noShirt, 120);
        Cyclist cyclist2 = new Cyclist("DOUBEY Fabien", 24, 15, 15, noShirt, 120);


        cyclingTeam1.addCyclists(Set.of(cyclist1, cyclist2));

        cyclingTeamRepository.saveAll(List.of(
                cyclingTeam1));
    }

    @Test
    public void getCyclist(){
        List<Cyclist> cyclistList = cyclistRepository.findAll();

        assertEquals(2, cyclistList.size());
    }
}