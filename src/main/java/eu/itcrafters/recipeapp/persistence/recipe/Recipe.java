package eu.itcrafters.recipeapp.persistence.recipe;

import eu.itcrafters.recipeapp.persistence.recipeingredient.RecipeIngredient;
import eu.itcrafters.recipeapp.persistence.category.Category;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "RECIPE")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "TITLE", nullable = false, length = 50)
    private String title;

    @Size(max = 350)
    @NotNull
    @Column(name = "DESCRIPTION", nullable = false, length = 350)
    private String description;

    @Size(max = 350)
    @NotNull
    @Column(name = "INSTRUCTIONS", nullable = false, length = 350)
    private String instructions;

    @Size(max = 50)
    @NotNull
    @Column(name = "CUISINE", nullable = false, length = 50)
    private String cuisine;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CATEGORY_ID", nullable = false)
    private Category category;

    @NotNull
    @Column(name = "CREATED_AT", nullable = false)
    private Instant createdAt;

    @NotNull
    @Column(name = "UPDATED_AT", nullable = false)
    private Instant updatedAt;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecipeIngredient> recipeIngredients = new ArrayList<>();

}