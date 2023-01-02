package com.backend.securityservice.repository;

import com.backend.securityservice.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<MyUser,Long> {

    MyUser findFirstByEmail(String email);

    List<MyUser> findAllByLocationContains(String location);

//    List<MyUser> findAllByRole_Nom(String role);

    List<MyUser> findAllByIdIsIn(List<Long> ids);

    @Query(value = "select mu,sum(pr.nb_stars) from MyUser mu left join PlayerRate pr" , nativeQuery = true)
    List<MyUser> test();
}
