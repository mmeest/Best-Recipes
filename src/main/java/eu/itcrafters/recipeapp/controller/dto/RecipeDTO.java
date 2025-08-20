package eu.itcrafters.recipeapp.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.Instant;

@Data
@Schema(description = "Recipe Data Transfer Object")
public class RecipeDTO {
    
    @Schema(description = "Recipe ID (auto-generated, not needed for POST)", example = "1")
    private Integer id;
    
    @Schema(description = "Recipe title", example = "Chicken Soup", required = true)
    @NotNull(message = "Title is required")
    @Size(max = 50, message = "Title must be less than 50 characters")
    private String title;
    
    @Schema(description = "Recipe description", example = "Warm soup with chicken and noodles", required = true)
    @NotNull(message = "Description is required")
    @Size(max = 350, message = "Description must be less than 350 characters")
    private String description;
    
    @Schema(description = "Cooking instructions", example = "Boil chicken, add noodles and vegetables", required = true)
    @NotNull(message = "Instructions are required")
    @Size(max = 350, message = "Instructions must be less than 350 characters")
    private String instructions;
    
    @Schema(description = "Cuisine type", example = "American", required = true)
    @NotNull(message = "Cuisine is required")
    @Size(max = 50, message = "Cuisine must be less than 50 characters")
    private String cuisine;
    
    @Schema(description = "Category ID (1=Soup, 2=Main Course, 3=Dessert, 4=Appetizer, 5=Smoothie)", example = "1", required = true)
    @NotNull(message = "Category ID is required")
    private Integer categoryId;
    
    @Schema(description = "Creation timestamp (auto-generated, not needed for POST)")
    private Instant createdAt;
    
    @Schema(description = "Last update timestamp (auto-generated, not needed for POST)")
    private Instant updatedAt;
}
