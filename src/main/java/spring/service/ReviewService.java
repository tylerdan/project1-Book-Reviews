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

    public Review findReviewById(int id){
        return reviewRepository.findById(id);
    }

    public int avgRating(String title){
        return reviewRepository.findAverageByTitle(title);
    }

    public List<Review> findReviewByTitle(String title) {
        return reviewRepository.findByTitle(title);
    }

    public void deleteReviewById(int id) {
        reviewRepository.deleteById(id);
    }

    public Review patchReview(Review review) {
        return saveReview(review);
    }
}
