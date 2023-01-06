package com.backend.stadiumservice.repository;

import com.backend.stadiumservice.model.PitchRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PitchRateRepository extends JpaRepository<PitchRate,Long> {

    PitchRate findFirstByReservation(String reservation_id);

    void deleteByReservation(String reservation_id);

    void deleteAllByPitch_idEquals(Long id);

    @Query("select pr , avg(pr.nb_stars) from PitchRate pr group by pr.pitch_id")
    List<PitchRate> findAllWithRate();
}
