package com.backend.stadiumservice.repository;

import com.backend.stadiumservice.model.Pitch;
import com.backend.stadiumservice.model.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VilleRepository extends JpaRepository<Ville,Long> {

    Ville findFirstById(Long id);
}
