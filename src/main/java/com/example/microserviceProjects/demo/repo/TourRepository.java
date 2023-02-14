package com.example.microserviceProjects.demo.repo;

import com.example.microserviceProjects.demo.domain.Tour;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

public interface TourRepository extends CrudRepository<Tour, Integer> {
    List<Tour> findByTourPackageCode(String code);
}
