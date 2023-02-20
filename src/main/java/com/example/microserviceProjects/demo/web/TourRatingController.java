package com.example.microserviceProjects.demo.web;

import com.example.microserviceProjects.demo.domain.TourRating;
//import com.example.microserviceProjects.demo.domain.TourRatingPk;
import com.example.microserviceProjects.demo.repo.TourRatingRepository;
import com.example.microserviceProjects.demo.repo.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path="/tours/{tourId}/ratings")
public class TourRatingController {
    TourRatingRepository tourRatingRepository;
    TourRepository tourRepository;

    @Autowired
    public TourRatingController(TourRatingRepository tourRatingRepository, TourRepository tourRepository) {
        this.tourRatingRepository = tourRatingRepository;
        this.tourRepository = tourRepository;
    }

    protected TourRatingController() {

    }
    @GetMapping
    public List<TourRating> getRatings(@PathVariable(value = "tourId") String tourId,
                                       Pageable pageable){
        return tourRatingRepository.findByTourId(tourId);
    }
//    @GetMapping
//    public List<RatingDto> getAllRatingsForTour(@PathVariable(value="tourId") int tourId) {
//        verifyTour(tourId);
//        return tourRatingRepository.findByPkTourId(tourId).stream()
//                .map(RatingDto::new).collect(Collectors.toList());
//    }

    @GetMapping(path = "/average")
    public Map<String, Double> getAverage(@PathVariable(value = "tourId") String tourId) {
        verifyTour(tourId);
        return Map.of("average",tourRatingRepository.findByTourId(tourId).stream()
                .mapToInt(TourRating::getScore).average()
                .orElseThrow(() ->
                        new NoSuchElementException("Tour has no Ratings")));
    }

//    @GetMapping(path = "/average")
//    public Map<String, Double> getAverage(@PathVariable (value = "tourId") int tourId) {
//        verifyTour(tourId);
//        return Map.of("average", tourRatingRepository.findByPkTourId(tourId).stream()
//                .mapToInt(TourRating::getScore).average()
//                .orElseThrow(() ->
//                        new NoSuchElementException("Tour has no ratings")));
//    }

//    @PutMapping
//    public RatingDto updateWithPut(@PathVariable(value = "tourId") int tourId, @RequestBody @Validated RatingDto ratingDto) {
//        TourRating rating = verifyTourRating(tourId, ratingDto.getCustomerId());
//        rating.setScore(ratingDto.getScore());
//        rating.setComment(ratingDto.getComment());
//        return new RatingDto(tourRatingRepository.save(rating));
//    }
    @PutMapping
    public TourRating updateWithPut(@PathVariable(value = "tourId") String tourId,
                                    @RequestBody @Validated TourRating tourRating) {
        TourRating rating = verifyTourRating(tourId, tourRating.getCustomerId());
        rating.setScore(tourRating.getScore());
        rating.setComment(tourRating.getComment());
        return tourRatingRepository.save(rating);
    }
//    @PatchMapping
//    public RatingDto updateWithPatch(@PathVariable(value = "tourId") int tourId, @RequestBody @Validated RatingDto ratingDto) {
//        TourRating rating = verifyTourRating(tourId, ratingDto.getCustomerId());
//        if (ratingDto.getScore() != null) {
//            rating.setScore(ratingDto.getScore());
//        }
//        if (ratingDto.getComment() != null) {
//            rating.setComment(ratingDto.getComment());
//        }
//        return new RatingDto(tourRatingRepository.save(rating));
//    }
    @PatchMapping
    public TourRating updateWithPatch(@PathVariable(value = "tourId") String tourId,
                                      @RequestBody @Validated TourRating tourRating) {
        TourRating rating = verifyTourRating(tourId, tourRating.getCustomerId());
        if (tourRating.getScore() != null) {
            rating.setScore(tourRating.getScore());
        }
        if (tourRating.getComment() != null) {
            rating.setComment(tourRating.getComment());
        }
        return tourRatingRepository.save(rating);
    }
    @DeleteMapping(path = "/{customerId}")
    public void delete(@PathVariable(value = "tourId") String tourId,
                       @PathVariable(value = "customerId") int customerId) {
        TourRating rating = verifyTourRating(tourId, customerId);
        tourRatingRepository.delete(rating);
    }
//    @DeleteMapping(path = "/{customerId}")
//    public void delete(@PathVariable(value = "tourId") int tourId, @PathVariable(value = "customerId") int customerId) {
//        TourRating rating = verifyTourRating(tourId, customerId);
//        tourRatingRepository.delete(rating);
//    }
//    private TourRating verifyTourRating(int tourId, int customerId) throws NoSuchElementException {
//        return tourRatingRepository.findByPkTourIdAndPkCustomerId(tourId, customerId).orElseThrow(() ->
//                new NoSuchElementException("Tour-Rating pair for request("
//                        + tourId + " for customer" + customerId));
//    }
    private TourRating verifyTourRating(String tourId, int customerId) throws NoSuchElementException {
        return tourRatingRepository.findByTourIdAndCustomerId(tourId, customerId).orElseThrow(() ->
                new NoSuchElementException("Tour-Rating pair for request("
                        + tourId + " for customer" + customerId));
    }

//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public void createTourRating(@PathVariable(value="tourId") int tourId, @RequestBody @Validated RatingDto ratingDto) {
//        Tour tour = verifyTour(tourId);
//        tourRatingRepository.save(new TourRating(new TourRatingPk(tour, ratingDto.getCustomerId()),
//                ratingDto.getScore(), ratingDto.getComment()));
//    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createTourRating(@PathVariable(value = "tourId") String tourId,
                                 @RequestBody @Validated TourRating tourRating) {
        verifyTour(tourId);
        tourRatingRepository.save(new TourRating(tourId, tourRating.getCustomerId(),
                tourRating.getScore(), tourRating.getComment()));
    }

//    private Tour verifyTour(int tourId) throws NoSuchElementException {
//        return tourRepository.findById(tourId).orElseThrow(() ->
//                new NoSuchElementException("Tour does not exist " + tourId));
//    }
    private void verifyTour(String tourId) throws NoSuchElementException {
//        if (!tourRepository.existsById(tourId)) {
//            throw new NoSuchElementException("Tour does not exist " + tourId);
//        }
    }


//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    @ExceptionHandler(NoSuchElementException.class)
//    public String return400(NoSuchElementException ex) {
//        return ex.getMessage();
//    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public String return400(NoSuchElementException ex) {
        return ex.getMessage();

    }
}
