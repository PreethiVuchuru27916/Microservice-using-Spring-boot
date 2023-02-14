package com.example.microserviceProjects.demo.repo;

import com.example.microserviceProjects.demo.domain.TourRating;
import com.example.microserviceProjects.demo.domain.TourRatingPk;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(exported = false)
public interface TourRatingRepository extends CrudRepository<TourRating, TourRatingPk> {
    List<TourRating> findByPkTourId(Integer tourId);
    List<TourRating> findByPKTourIdandPkCustomerId(Integer tourId, Integer customerId);
}
