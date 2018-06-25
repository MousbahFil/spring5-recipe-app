package guru.springframework.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Data
@EqualsAndHashCode(of = "id")
@ToString(exclude = "recipe")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private BigDecimal amount;
    @ManyToOne
    @JsonIgnore
    private Recipe recipe;
    @OneToOne(cascade = CascadeType.ALL)
    private UnitOfMeasure unitOfMeasure;



    public Ingredient() {
    }

    public Ingredient(String description, BigDecimal amount) {
        this.description = description;
        this.amount = amount;
    }

}
