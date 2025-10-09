package com.example.aimagency.repository;

import com.example.aimagency.model.Etkinlik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtkinlikRepository extends JpaRepository<Etkinlik, Long> {
}
