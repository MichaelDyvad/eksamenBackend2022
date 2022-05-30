package com.example.eksamenprogrammering2022.repository;

import com.example.eksamenprogrammering2022.entity.Shirt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShirtRepository extends JpaRepository<Shirt, Integer> {
}
