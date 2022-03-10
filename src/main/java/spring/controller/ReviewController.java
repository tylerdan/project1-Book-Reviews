package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.model.Book;
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

    @GetMapping("reviewtitle/{title}")
    public List<Review> getReviewsByTitle(@PathVariable String title) {
        return reviewService.findReviewByTitle(title);
    }

    @GetMapping("reviewid/{id}")
    public Review getReviewById(@PathVariable int id) {
        return reviewService.findReviewById(id);
    }

    @GetMapping("average/{title}")
    public int getAvgRating(@PathVariable String title) {
        return reviewService.avgRating(title);
    }

    @PostMapping("postreview"/*consumes = {"application/xml","application/json"}*/)
    public Review postReview(@RequestBody Review review) {
        return reviewService.saveReview(review);
    }

    @DeleteMapping("review/{id}")
    public void deleteReview(@PathVariable int id) {
        reviewService.deleteReviewById(id);
    }

    @PatchMapping("/updatereview/{id}")
    public Review updateBook(@PathVariable int id, @RequestBody Review review) {
        Review savedReview = getReviewById(id);
        if(review.getReview()!=null) {
            savedReview.setReview(review.getReview());
        }
        System.out.println(review.getRating()!=0);
        if(review.getRating()!=0) {
            savedReview.setRating(review.getRating());
        }
        return reviewService.patchReview(savedReview);
    }
}
