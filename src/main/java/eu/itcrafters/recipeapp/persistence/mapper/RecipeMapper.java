package eu.itcrafters.recipeapp.persistence.mapper;

import eu.itcrafters.recipeapp.controller.dto.RecipeDTO;
import eu.itcrafters.recipeapp.persistence.recipe.Recipe;
import eu.itcrafters.recipeapp.persistence.category.Category;
import org.springframework.stereotype.Component;

@Component
public class RecipeMapper {

    public RecipeDTO toDTO(Recipe recipe) {
        if (recipe == null) {
            return null;
        }

        RecipeDTO dto = new RecipeDTO();
        dto.setId(recipe.getId());
        dto.setTitle(recipe.getTitle());
        dto.setDescription(recipe.getDescription());
        dto.setInstructions(recipe.getInstructions());
        dto.setCuisine(recipe.getCuisine());
        dto.setCategoryId(recipe.getCategory() != null ? recipe.getCategory().getId() : null);
        dto.setCreatedAt(recipe.getCreatedAt());
        dto.setUpdatedAt(recipe.getUpdatedAt());

        return dto;
    }

    public Recipe toEntity(RecipeDTO dto) {
        if (dto == null) {
            return null;
        }

        Recipe recipe = new Recipe();
        recipe.setId(dto.getId());
        recipe.setTitle(dto.getTitle());
        recipe.setDescription(dto.getDescription());
        recipe.setInstructions(dto.getInstructions());
        recipe.setCuisine(dto.getCuisine());
        recipe.setCreatedAt(dto.getCreatedAt());
        recipe.setUpdatedAt(dto.getUpdatedAt());

        return recipe;
    }
}
