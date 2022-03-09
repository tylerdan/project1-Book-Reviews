package spring.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Book")
@JsonIdentityInfo(
        //this is to stop recursive hibernate joins
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "title"
)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {
    @Id
    private String title;
    private String author;
    private int yearPublish;
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name="title")
    private List<Review> reviews = new ArrayList<>();
   // @JsonIgnoreProperties(value="bookTitle")

}
