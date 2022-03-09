package spring.service;

import org.springframework.stereotype.Component;
import spring.model.Review;
import spring.repository.ReviewRepository;


import java.util.List;
@Component
public class ReviewService {
    ReviewRepository reviewRepository;
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

    /*public int avgRating(String title){
        return reviewRepository.findAverage(title);
    }*/

    public List<Review> findReviewByTitle(String title) {
        return reviewRepository.findByTitle(title);
    }
}
