package com.example.eksamenprogrammering2022.configuration;

import com.example.eksamenprogrammering2022.entity.CyclingTeam;
import com.example.eksamenprogrammering2022.entity.Cyclist;
import com.example.eksamenprogrammering2022.entity.Shirt;
import com.example.eksamenprogrammering2022.repository.CyclingTeamRepository;
import com.example.eksamenprogrammering2022.repository.CyclistRepository;
import com.example.eksamenprogrammering2022.repository.ShirtRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
@Profile("!test")
public class MakeTestData implements ApplicationRunner {

    CyclistRepository cyclistRepository;
    CyclingTeamRepository cyclingTeamRepository;
    ShirtRepository shirtRepository;

    public MakeTestData(CyclistRepository cyclistRepository, CyclingTeamRepository cyclingTeamRepository, ShirtRepository shirtRepository) {
        this.cyclistRepository = cyclistRepository;
        this.cyclingTeamRepository = cyclingTeamRepository;
        this.shirtRepository = shirtRepository;
    }

    //Skal lave data til databasen
    public void makeAllTest(){
        CyclingTeam cyclingTeam1 = new CyclingTeam("TotalEnergies");
        CyclingTeam cyclingTeam2 = new CyclingTeam("TeamDSM");
        CyclingTeam cyclingTeam3 = new CyclingTeam("Cofidis");

        Shirt noShirt = new Shirt("noshirt");
        shirtRepository.save(noShirt);
        Cyclist cyclist1 = new Cyclist("FERRON Valentin", 26, 20, 15, noShirt);
        Cyclist cyclist2 = new Cyclist("DOUBEY Fabien", 24, 15, 15, noShirt);
        Cyclist cyclist3 = new Cyclist("BOL Cees", 24, 15, 15, noShirt);
        Cyclist cyclist4 = new Cyclist("DEGENKOLB John", 22, 15, 15, noShirt);
        Cyclist cyclist5 = new Cyclist("PÉRICHON Pierre-Luc", 22, 15, 15, noShirt);
        Cyclist cyclist6 = new Cyclist("MARTIN Guillaume", 22, 15, 15, noShirt);

        cyclingTeam1.addCyclists(Set.of(cyclist1, cyclist2));
        cyclingTeam2.addCyclists(Set.of(cyclist3, cyclist4));
        cyclingTeam3.addCyclists(Set.of(cyclist5, cyclist6));

        cyclingTeamRepository.saveAll(List.of(
           cyclingTeam1,
           cyclingTeam2,
           cyclingTeam3));


        Shirt shirt1 = new Shirt("yellow");
        Shirt shirt2 = new Shirt("white");
        Shirt shirt3 = new Shirt("green");
        Shirt shirt4 = new Shirt("dotted");

        shirtRepository.save(shirt1);
        shirtRepository.save(shirt2);
        shirtRepository.save(shirt3);
        shirtRepository.save(shirt4);

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        makeAllTest();
    }
}
