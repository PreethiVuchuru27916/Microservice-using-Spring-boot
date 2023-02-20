package com.example.microserviceProjects.demo.domain;

//import jakarta.persistence.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;
import java.util.Objects;
@Document
//@Entity
public class Tour {
    @Id
    private String id;
    //@GeneratedValue
    //private Integer id;
    //@Column
    @Indexed
    private String title;
    //@Column(length = 2000)
    //private String description;
    //@Column(length = 2000)
    //private String blurb;
    //@Column
    //private Integer price;
    //@Column
    //private String duration;
    @Indexed
    private String tourPackageCode;
    @Indexed
    private String tourPackageName;
    private Map<String, String> details;
//    @Column(length = 2000)
//    private String bullets;
    //@Column
    //private String keywords;
    //@ManyToOne
    //private TourPackage tourPackage;
    //@Column
    //@Enumerated
    //private Region region;
    //@Column
    //@Enumerated
    //private Difficulty difficulty;

    public Tour() {

    }
    /*public Tour(String title, String description, String blurb, Integer price, String duration, String bullets, String keywords, TourPackage tourPackage, Region region, Difficulty difficulty) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.blurb = blurb;
        this.price = price;
        this.duration = duration;
        this.bullets = bullets;
        this.keywords = keywords;
        this.tourPackage = tourPackage;
        this.region = region;
        this.difficulty = difficulty;
    }*/

    public Tour(String title, TourPackage tourPackage, Map<String, String> details) {
        this.title = title;
        this.details = details;
        this.tourPackageCode = tourPackage.getCode();
        this.tourPackageName = tourPackage.getName();
    }

    /*public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBlurb() {
        return blurb;
    }

    public void setBlurb(String blurb) {
        this.blurb = blurb;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getBullets() {
        return bullets;
    }

    public void setBullets(String bullets) {
        this.bullets = bullets;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public TourPackage getTourPackage() {
        return tourPackage;
    }

    public void setTourPackage(TourPackage tourPackage) {
        this.tourPackage = tourPackage;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }*/

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getTourPackageCode() {
        return tourPackageCode;
    }

    public String getTourPackageName() {
        return tourPackageName;
    }

    public Map<String, String> getDetails() {
        return details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tour)) return false;
        Tour tour = (Tour) o;
        return Objects.equals(id, tour.id) && Objects.equals(details, tour.details);
    }

    @Override
    public String toString() {
        return "Tour{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", tourPackageCode='" + tourPackageCode + '\'' +
                ", tourPackageName='" + tourPackageName + '\'' +
                ", details=" + details +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, details);
    }


}
