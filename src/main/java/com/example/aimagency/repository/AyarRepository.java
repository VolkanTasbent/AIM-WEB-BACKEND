package com.example.aimagency.repository;

import com.example.aimagency.model.Ayar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AyarRepository extends JpaRepository<Ayar, Long> {
}
