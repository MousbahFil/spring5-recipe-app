package guru.springframework.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String value;

    @OneToOne
    @JsonIgnore
    private Recipe recipe;

    public Notes() {
    }

    public Notes( String value) {
        this.value = value;
    }

}
