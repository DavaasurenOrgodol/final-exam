package com.example.test.demo.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.test.demo.domain.Astronaut;

@Repository
public interface AstronautRepository extends JpaRepository<Astronaut, Long> {
    Page<Astronaut> findAll(Pageable pageable);

    // Optional<Astronaut> findAstronautById();

    Optional<Astronaut> findAstronautByFirstNameAndLastName(@Param(value = "firstName") String fistName,
            @Param(value = "lastName") String LastName);
}
