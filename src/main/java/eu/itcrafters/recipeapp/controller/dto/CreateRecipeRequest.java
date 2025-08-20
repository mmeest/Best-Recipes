package eu.itcrafters.recipeapp.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = "Create Recipe Request - only required fields for creating a new recipe")
public class CreateRecipeRequest {
    
    @Schema(description = "Recipe title", required = true)
    @NotNull(message = "Title is required")
    @Size(max = 50, message = "Title must be less than 50 characters")
    private String title;
    
    @Schema(description = "Recipe description", required = true)
    @NotNull(message = "Description is required")
    @Size(max = 350, message = "Description must be less than 350 characters")
    private String description;
    
    @Schema(description = "Cooking instructions", required = true)
    @NotNull(message = "Instructions are required")
    @Size(max = 350, message = "Instructions must be less than 350 characters")
    private String instructions;
    
    @Schema(description = "Cuisine type", required = true)
    @NotNull(message = "Cuisine is required")
    @Size(max = 50, message = "Cuisine must be less than 50 characters")
    private String cuisine;
    
    @Schema(description = "Category ID (1=Soup, 2=Main Course, 3=Dessert, 4=Appetizer, 5=Smoothie)", required = true)
    @NotNull(message = "Category ID is required")
    private Integer categoryId;
}
