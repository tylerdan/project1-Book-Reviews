package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.service.ReviewService;
import spring.model.Review;

import java.util.List;

@RestController
public class ReviewController {
    ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("reviews/{title}")
    public List<Review> getReviewsByTitle(@PathVariable String title) {
        return reviewService.findReviewByTitle(title);
    }

    @GetMapping("average/{title}")
    public int getAvgRating(@PathVariable String title) {
        return reviewService.avgRating(title);
    }

    @PostMapping("postreview"/*consumes = {"application/xml","application/json"}*/)
    public Review postReview(@RequestBody Review review) {
        return reviewService.saveReview(review);
    }
}
