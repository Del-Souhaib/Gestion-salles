package com.backend.securityservice.repository;

import com.backend.securityservice.model.PlayerRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRateRepository extends JpaRepository<PlayerRate,Long> {

    PlayerRate findFirstByReservationAndPlayer_id(String reservation_id,Long player_id);
}
