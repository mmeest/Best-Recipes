package eu.itcrafters.recipeapp.controller.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class RecipeDTO {
    private Integer id;
    private String title;
    private String description;
    private String instructions;
    private String cuisine;
    private Integer categoryId;
    private Instant createdAt;
    private Instant updatedAt;
}
