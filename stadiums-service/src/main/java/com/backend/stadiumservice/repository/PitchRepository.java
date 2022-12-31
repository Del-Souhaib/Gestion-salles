package com.backend.stadiumservice.repository;

import com.backend.stadiumservice.model.Pitch;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PitchRepository extends JpaRepository<Pitch,Long> {

    Pitch findFirstById(Long id);
    @Query("select p from Pitch p Where (:capacity is null or p.capacity = :capacity)  and (:ville is null or p.ville_id= :ville) ")
    List<Pitch> search(@Param("capacity") Integer capacity,@Param("ville") Long ville);
}
