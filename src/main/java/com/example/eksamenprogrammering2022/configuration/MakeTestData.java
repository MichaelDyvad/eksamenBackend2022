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

        Shirt shirt1 = new Shirt("Gul");
        Shirt shirt2 = new Shirt("Hvid");
        Shirt shirt3 = new Shirt("Grøn");
        Shirt shirt4 = new Shirt("Bjergtrøjen");

        Shirt noShirt = new Shirt(" ");
        shirtRepository.save(noShirt);
        shirtRepository.save(shirt1);
        shirtRepository.save(shirt2);
        shirtRepository.save(shirt3);
        shirtRepository.save(shirt4);


        Cyclist cyclist1 = new Cyclist("FERRON Valentin", 26, 20, 15, shirt4, 160, "Italien");
        Cyclist cyclist2 = new Cyclist("DOUBEY Fabien", 24, 15, 15, shirt2, 120, "Italien");
        Cyclist cyclist3 = new Cyclist("VUILLERMOZ Alexis", 23, 5, 5, noShirt, 131, "Italien");
        Cyclist cyclist4 = new Cyclist("JOUSSEAUME Alan", 25,5, 5, noShirt, 132, "Italien");
        Cyclist cyclist5 = new Cyclist("SAGAN Peter", 227, 5, 5, noShirt, 133, "Italien");

        Cyclist cyclist6 = new Cyclist("BOL Cees", 24, 12, 20, shirt3, 140, "Danmark");
        Cyclist cyclist7 = new Cyclist("DEGENKOLB John", 27, 11, 15, shirt1, 110, "Danmark");
        Cyclist cyclist8 = new Cyclist("EEKHOFF Nils", 23, 7, 7, noShirt, 171, "Danmark");
        Cyclist cyclist9 = new Cyclist("BARDET Romain", 28, 7, 7, noShirt, 164, "Danmark");
        Cyclist cyclist10 = new Cyclist("KRAGH ANDERSEN Søren", 25, 7, 7, noShirt, 172, "Danmark");

        Cyclist cyclist11 = new Cyclist("PÉRICHON Pierre-Luc", 22, 10, 10, noShirt, 162, "Frankrig");
        Cyclist cyclist12 = new Cyclist("MARTIN Guillaume", 21, 2, 4, noShirt, 154, "Frankrig");
        Cyclist cyclist13 = new Cyclist("COQUARD Bryan", 19, 3, 5, noShirt, 153, "Frankrig");
        Cyclist cyclist14 = new Cyclist("IZAGIRRE Ion", 28, 2, 5, noShirt, 152,"Frankrig");
        Cyclist cyclist15 = new Cyclist("THOMAS Benjamin", 32, 1, 5, noShirt, 150, "Frankrig");






        cyclingTeam1.addCyclists(Set.of(cyclist1, cyclist2, cyclist3, cyclist4, cyclist5));
        cyclingTeam2.addCyclists(Set.of(cyclist6, cyclist7, cyclist8, cyclist9, cyclist10));
        cyclingTeam3.addCyclists(Set.of(cyclist11, cyclist12, cyclist13, cyclist14, cyclist15));


        cyclingTeamRepository.saveAll(List.of(
           cyclingTeam1,
           cyclingTeam2,
           cyclingTeam3));

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        makeAllTest();
    }
}
