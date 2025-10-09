package com.example.aimagency.repository;

import com.example.aimagency.model.Haber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HaberRepository extends JpaRepository<Haber, Long> {
}
