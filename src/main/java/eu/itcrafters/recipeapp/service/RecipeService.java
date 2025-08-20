package eu.itcrafters.recipeapp.service;

import eu.itcrafters.recipeapp.controller.dto.RecipeDTO;
import eu.itcrafters.recipeapp.controller.dto.CreateRecipeRequest;
import eu.itcrafters.recipeapp.controller.dto.UpdateRecipeRequest;
import eu.itcrafters.recipeapp.persistence.mapper.RecipeMapper;
import eu.itcrafters.recipeapp.persistence.recipe.Recipe;
import eu.itcrafters.recipeapp.persistence.recipe.RecipeRepository;
import eu.itcrafters.recipeapp.persistence.category.Category;
import eu.itcrafters.recipeapp.persistence.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final CategoryRepository categoryRepository;
    private final RecipeMapper recipeMapper;

    public RecipeDTO getRecipe(Integer recipeId) {
        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new RuntimeException("Recipe not found with id: " + recipeId));
        return recipeMapper.toDTO(recipe);
    }

    public List<RecipeDTO> getAllRecipes() {
        List<Recipe> recipes = recipeRepository.findAll();
        return recipes.stream()
                .map(recipeMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public RecipeDTO addRecipe(CreateRecipeRequest request) {
        // Convert CreateRecipeRequest to RecipeDTO first
        RecipeDTO recipeDTO = recipeMapper.fromCreateRequest(request);
        
        Recipe recipe = recipeMapper.toEntity(recipeDTO);
        
        // Set timestamps
        Instant now = Instant.now();
        recipe.setCreatedAt(now);
        recipe.setUpdatedAt(now);
        
        // Category is required - throw exception if not provided
        if (recipeDTO.getCategoryId() == null) {
            throw new RuntimeException("Category ID is required");
        }
        
        Category category = categoryRepository.findById(recipeDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + recipeDTO.getCategoryId()));
        recipe.setCategory(category);
        
        Recipe savedRecipe = recipeRepository.save(recipe);
        return recipeMapper.toDTO(savedRecipe);
    }

    public RecipeDTO updateRecipe(Integer recipeId, UpdateRecipeRequest request) {
        // Convert UpdateRecipeRequest to RecipeDTO first
        RecipeDTO recipeDTO = recipeMapper.fromUpdateRequest(request);
        
        Recipe existingRecipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new RuntimeException("Recipe not found with id: " + recipeId));
        
        // Update only non-null fields
        if (recipeDTO.getTitle() != null) {
            existingRecipe.setTitle(recipeDTO.getTitle());
        }
        if (recipeDTO.getDescription() != null) {
            existingRecipe.setDescription(recipeDTO.getDescription());
        }
        if (recipeDTO.getInstructions() != null) {
            existingRecipe.setInstructions(recipeDTO.getInstructions());
        }
        if (recipeDTO.getCuisine() != null) {
            existingRecipe.setCuisine(recipeDTO.getCuisine());
        }
        existingRecipe.setUpdatedAt(Instant.now());
        
        // Update category if categoryId is provided
        if (recipeDTO.getCategoryId() != null) {
            Category category = categoryRepository.findById(recipeDTO.getCategoryId())
                    .orElseThrow(() -> new RuntimeException("Category not found with id: " + recipeDTO.getCategoryId()));
            existingRecipe.setCategory(category);
        }
        
        Recipe updatedRecipe = recipeRepository.save(existingRecipe);
        return recipeMapper.toDTO(updatedRecipe);
    }

    @Transactional
    public void deleteRecipe(Integer recipeId) {
        if (!recipeRepository.existsById(recipeId)) {
            throw new RuntimeException("Recipe not found with id: " + recipeId);
        }
        
        // JPA will automatically delete related recipe-ingredient relationships due to cascade
        recipeRepository.deleteById(recipeId);
    }
}
