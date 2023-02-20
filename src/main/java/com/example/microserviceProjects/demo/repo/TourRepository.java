package com.example.microserviceProjects.demo.repo;

import com.example.microserviceProjects.demo.domain.Tour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface TourRepository extends PagingAndSortingRepository<Tour, String> {
    //List<Tour> findByTourPackageCode(String code);
    Page<Tour> findByTourPackageCode(@Param("code")String code, Pageable pageable);
    @Query(value = "{'tourPackageCode' : ?0 }",
            fields = "{ 'id':1, 'title':1, 'tourPackageCode':1, 'tourPackageName':1}")
    Page<Tour> findSummaryByTourPackageCode(@Param("code")String code, Pageable pageable);
   // @Override
    @RestResource(exported = false)
    <S extends Tour> S save(S s);

    //@Override
    @RestResource(exported = false)
    <S extends Tour> Iterable<S> saveAll(Iterable<S> iterable);

    //@Override
    @RestResource(exported = false)
    void deleteById(String string);

    //@Override
    @RestResource(exported = false)
    void delete(Tour tour);

    //@Override
    @RestResource(exported = false)
    void deleteAll(Iterable<? extends Tour> iterable);

    //@Override
    @RestResource(exported = false)
    void deleteAll();
}
