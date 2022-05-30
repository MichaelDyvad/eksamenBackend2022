package com.example.eksamenprogrammering2022.repository;

import com.example.eksamenprogrammering2022.entity.Cyclist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CyclistRepository extends JpaRepository<Cyclist, Integer> {
    List<Cyclist> findCyclistByCyclingTeam_name(String teamName);
}
