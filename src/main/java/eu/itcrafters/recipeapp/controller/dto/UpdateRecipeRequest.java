package eu.itcrafters.recipeapp.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = "Update Recipe Request - only fields that can be updated")
public class UpdateRecipeRequest {
    
    @Schema(description = "Recipe title")
    @Size(max = 50, message = "Title must be less than 50 characters")
    private String title;
    
    @Schema(description = "Recipe description")
    @Size(max = 350, message = "Description must be less than 350 characters")
    private String description;
    
    @Schema(description = "Cooking instructions")
    @Size(max = 350, message = "Instructions must be less than 350 characters")
    private String instructions;
    
    @Schema(description = "Cuisine type")
    @Size(max = 50, message = "Cuisine must be less than 50 characters")
    private String cuisine;
    
    @Schema(description = "Category ID (1=Soup, 2=Main Course, 3=Dessert, 4=Appetizer, 5=Smoothie)")
    private Integer categoryId;
}
