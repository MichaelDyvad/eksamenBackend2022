package com.example.eksamenprogrammering2022.api;


import com.example.eksamenprogrammering2022.dto.CyclistRequest;
import com.example.eksamenprogrammering2022.dto.CyclistResponse;
import com.example.eksamenprogrammering2022.service.CyclistService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/cyclist")
public class CyclistController {

    CyclistService cyclistService;

    public CyclistController(CyclistService cyclistService) {
        this.cyclistService = cyclistService;
    }

    @GetMapping
    public List<CyclistResponse> getCyclists(){
        return cyclistService.getCyclists();
    }

    @GetMapping("/find/{id}")
    public CyclistResponse getCyclistFromId(@PathVariable int id){
        return cyclistService.getCyclistFromId(id);
    }

    @GetMapping("/{teamname}")
    public List<CyclistResponse> getAllCyclistFromTeam(@PathVariable String teamname){
        return cyclistService.getAllCyclistOnTeamId(teamname);
    }

    @PostMapping()
    public void addNewCyclist(@RequestBody CyclistRequest body){
        cyclistService.addNewCyclist(body);
    }

    @PutMapping("/{id}")
    public CyclistResponse editCyclist(@RequestBody CyclistRequest body, @PathVariable int id){
        return cyclistService.editCyclist(body, id);
    }

    @DeleteMapping("/{id}")
    public void deleteCyclist(@PathVariable int id){
        cyclistService.deleteCyclist(id);
    }
}
