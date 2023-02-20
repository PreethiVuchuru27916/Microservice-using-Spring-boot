package com.example.microserviceProjects.demo.repo;

import com.example.microserviceProjects.demo.domain.TourRating;
//import com.example.microserviceProjects.demo.domain.TourRatingPk;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(exported = false)
//public interface TourRatingRepository extends CrudRepository<TourRating, TourRatingPk> {

public interface TourRatingRepository extends CrudRepository<TourRating, String> {
    //List<TourRating> findByPkTourId(Integer tourId);
    List<TourRating> findByTourId(String tourId);
    //Optional<TourRating> findByPkTourIdAndPkCustomerId(Integer tourId, Integer customerId);
    Page<TourRating> findByTourId(String tourId, Pageable pageable);

    Optional<TourRating> findByTourIdAndCustomerId(String tourId, Integer customerId);
}
