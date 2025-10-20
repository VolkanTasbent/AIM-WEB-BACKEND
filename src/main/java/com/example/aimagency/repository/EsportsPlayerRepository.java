package com.example.aimagency.repository;

import com.example.aimagency.model.EsportsPlayer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EsportsPlayerRepository extends JpaRepository<EsportsPlayer, Long> {
}
