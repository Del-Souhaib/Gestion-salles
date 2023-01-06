package com.backend.securityservice.repository;

import com.backend.securityservice.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<MyUser,Long> {

    MyUser findFirstByEmail(String email);

    List<MyUser> findAllByLocationContains(String location);

//    List<MyUser> findAllByRole_Nom(String role);

//    @Query("select u,r from MyUser u left join u.rates r where  u.id in :player_ids ")
//    List<MyUser> findAllByIdIsIn(@Param("player_ids") List<Long> player_ids,@Param("reservation_id") String reservation_id);

    List<MyUser> findAllByIdIsIn(List<Long> player_ids);

//    List<MyUser> findAllByIdIsInAndAndratAndRatesIsNull

    List<MyUser> findAllByEmailContaining(String email);
    @Query(value = "select mu,sum(pr.nb_stars) from MyUser mu left join PlayerRate pr" , nativeQuery = true)
    List<MyUser> test();
}
