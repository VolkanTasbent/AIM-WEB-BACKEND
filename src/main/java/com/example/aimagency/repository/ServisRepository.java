package com.example.aimagency.repository;

import com.example.aimagency.model.Servis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServisRepository extends JpaRepository<Servis, Long> {
}
