package com.example.aimagency.repository;

import com.example.aimagency.model.AltServis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AltServisRepository extends JpaRepository<AltServis, Long> {
}
