package com.example.microserviceProjects.demo.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Tour {
    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String title;
    @Column(length = 2000)
    private String description;
    @Column(length = 2000)
    private String blurb;
    @Column
    private Integer price;
    @Column
    private String duration;
    @Column(length = 2000)
    private String bullets;
    @Column
    private String keywords;
    @ManyToOne
    private TourPackage tourPackage;
    @Column
    @Enumerated
    private Region region;
    @Column
    @Enumerated
    private Difficulty difficulty;

    public Tour() {

    }
    public Tour(String title, String description, String blurb, Integer price, String duration, String bullets, String keywords, TourPackage tourPackage, Region region, Difficulty difficulty) {
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
    }

    public Integer getId() {
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
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tour)) return false;
        Tour tour = (Tour) o;
        return Objects.equals(id, tour.id) && Objects.equals(title, tour.title) && Objects.equals(description, tour.description) && Objects.equals(blurb, tour.blurb) && Objects.equals(price, tour.price) && Objects.equals(duration, tour.duration) && Objects.equals(bullets, tour.bullets) && Objects.equals(keywords, tour.keywords) && Objects.equals(tourPackage, tour.tourPackage) && region == tour.region && difficulty == tour.difficulty;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, blurb, price, duration, bullets, keywords, tourPackage, region, difficulty);
    }
}
