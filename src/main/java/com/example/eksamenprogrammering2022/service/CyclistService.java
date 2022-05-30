package com.example.eksamenprogrammering2022.service;

import com.example.eksamenprogrammering2022.dto.CyclistRequest;
import com.example.eksamenprogrammering2022.dto.CyclistResponse;
import com.example.eksamenprogrammering2022.entity.Cyclist;
import com.example.eksamenprogrammering2022.repository.CyclistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CyclistService {

    CyclistRepository cyclistRepository;

    public CyclistService(CyclistRepository cyclistRepository) {
        this.cyclistRepository = cyclistRepository;
    }

    public List<CyclistResponse> getCyclists(){
        List<Cyclist> cyclists = cyclistRepository.findAll();
        return CyclistResponse.getCyclistFromEntity(cyclists);
    }

    public CyclistResponse getCyclistFromId(int id){
        Cyclist cyclist = cyclistRepository.findById(id).orElseThrow(()-> new RuntimeException());
        return new CyclistResponse(cyclist);
    }

    public List<CyclistResponse> getAllCyclistOnTeamId(String id){
        List<Cyclist> cyclists = cyclistRepository.findCyclistByCyclingTeam_name(id);
        return CyclistResponse.getCyclistFromEntity(cyclists);
    }

    public void addNewCyclist(CyclistRequest body){
        cyclistRepository.save(new Cyclist(body));
    }

    public CyclistResponse editCyclist(CyclistRequest body, int cyclistId){
        Cyclist cyclist = cyclistRepository.findById(cyclistId).orElseThrow(()-> new RuntimeException());
        cyclist.setName(body.getName());
        cyclist.setAge(body.getAge());
        cyclist.setMountainPoints(body.getMountainPoints());
        cyclist.setSpurtPoints(body.getSpurtPoints());
        cyclist.setShirt(body.getShirt());
        cyclist.setCyclingTeam(body.getCyclingTeam());
        cyclist.setTime(body.getTime());
        cyclistRepository.save(cyclist);
        return new CyclistResponse(cyclist);
    }

    public void deleteCyclist(int cyclistId){
        cyclistRepository.deleteById(cyclistId);
    }
}
