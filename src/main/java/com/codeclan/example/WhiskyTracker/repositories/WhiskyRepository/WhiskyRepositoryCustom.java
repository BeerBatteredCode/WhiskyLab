package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;

import com.codeclan.example.WhiskyTracker.models.Whisky;

import java.util.List;

public interface WhiskyRepositoryCustom {

    List<Whisky> findAllWhiskyByDistilleryAndAge(String distillery, int age);

    List<Whisky> findAllWhiskyByRegion(String region);

}
