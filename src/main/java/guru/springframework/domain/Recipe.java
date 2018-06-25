package guru.springframework.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(of = "id")
@ToString(exclude = {"ingredients","categories","notes"})

public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    private int prepTime;
    private int cookTime;
    private int servings;
    private String source;
    private String url;
    @Lob
    private String directions;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "recipe_category", joinColumns =@JoinColumn(name = "recipe_id"),
            inverseJoinColumns =@JoinColumn(name = "category_id"))
    private Set<Category> categories;

    @Enumerated(EnumType.ORDINAL )
    private Difficulty difficulty;

    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

    @Lob
    private byte[] image;

    public Recipe() {
        ingredients=new HashSet<>();
        categories=new HashSet<>();
        difficulty=Difficulty.EASY;
    }

    public void addIngredient(Ingredient ingredient){
        ingredients.add(ingredient);
        ingredient.setRecipe(this);
    }

    public void addCategory(Category category){
        categories.add(category);
        category.getRecipes().add(this);
    }


    public void setNotes(Notes notes) {
        this.notes = notes;
        notes.setRecipe(this);
    }


}
