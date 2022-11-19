package com.backend.stadiumservice.repository;

import com.backend.stadiumservice.model.PitchRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PitchRateRepository extends JpaRepository<PitchRate,Long> {
}
