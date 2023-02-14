package com.example.microserviceProjects.demo.service;

import com.example.microserviceProjects.demo.domain.Difficulty;
import com.example.microserviceProjects.demo.domain.Region;
import com.example.microserviceProjects.demo.domain.Tour;
import com.example.microserviceProjects.demo.domain.TourPackage;
import com.example.microserviceProjects.demo.repo.TourPackageRepository;
import com.example.microserviceProjects.demo.repo.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourService {
    private TourRepository tourRepository;
    private TourPackageRepository tourPackageRepository;

    @Autowired
    public TourService(TourRepository tourRepository, TourPackageRepository tourPackageRepository) {
        this.tourRepository = tourRepository;
        this.tourPackageRepository = tourPackageRepository;
    }

    //Creating a tour package
    public Tour createTour(String title, String description, String blurb, Integer price, String duration, String bullets, String keywords, String tourPackageName, Difficulty difficulty, Region region) {
        TourPackage tourPackage = tourPackageRepository.findByName(tourPackageName)
                .orElseThrow(() -> new RuntimeException("Tour does not exist "+tourPackageName));
        return tourRepository.save(new Tour(title, description,blurb, price, duration, bullets, keywords, tourPackage, region, difficulty));
    }

    public long total() {
        return tourRepository.count();
    }

}
