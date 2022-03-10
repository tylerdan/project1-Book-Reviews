package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import spring.model.Review;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    Review save(Review review);
    List<Review> findByTitle(String title);
    @Query(value = "SELECT AVG(rating) FROM review WHERE title = :title", nativeQuery = true)
    int findAverageByTitle(String title);
    Review findById(int id);
    void deleteById(int id);

}
