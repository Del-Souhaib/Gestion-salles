package com.backend.stadiumservice.repository;

import com.backend.stadiumservice.model.PitchImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PitchImageRepository extends JpaRepository<PitchImage,Long> {
}
