package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WhiskyRepository extends JpaRepository<Whisky, Long>, WhiskyRepositoryCustom {

    List<Whisky> findWhiskyByAge(int age);

    List<Whisky> findAllWhiskyByDistilleryAndAge(String distillery, int age);

    List<Whisky> findAllWhiskyByRegion(String region);

}
