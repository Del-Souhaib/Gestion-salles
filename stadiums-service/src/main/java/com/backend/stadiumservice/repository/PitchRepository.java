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

    @Query( "select p,avg(pr.nb_stars) from Pitch p left join p.pitchRates pr on p.id=pr.pitch_id Where p.id= :id group by p")
    Pitch findFirstById(@Param("id") Long id);
    @Query( "select p,avg(pr.nb_stars) from Pitch p left join p.pitchRates pr on p.id=pr.pitch_id Where (:capacity is null or p.capacity = :capacity)  and (:ville is null or p.ville_id= :ville) group by p")
    List<Pitch> search(@Param("capacity") Integer capacity,@Param("ville") Long ville);

}
