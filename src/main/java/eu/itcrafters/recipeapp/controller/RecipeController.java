package eu.itcrafters.recipeapp.controller;

import eu.itcrafters.recipeapp.controller.dto.RecipeDTO;
import eu.itcrafters.recipeapp.infrastructure.rest.error.ApiError;
import eu.itcrafters.recipeapp.service.RecipeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

    @GetMapping("/recipe/{recipeId}")
    @Operation(summary = "Finds a recipe by its ID", description = "Finds a recipe by its ID, if no match is found then error is thrown")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Recipe does not exist",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public ResponseEntity<RecipeDTO> getRecipe(@PathVariable Integer recipeId) {
        try {
            RecipeDTO recipe = recipeService.getRecipe(recipeId);
            return ResponseEntity.ok(recipe);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/recipe")
    @Operation(summary = "Adds a recipe", description = "Adds a recipe. Throws error 'Category not found' if category is not found from system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created"),
            @ApiResponse(responseCode = "400", description = "Invalid request body: payload validation failed",
                    content = @Content(schema = @Schema(implementation = ApiError.class))),
            @ApiResponse(responseCode = "404", description = "Category not found",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public ResponseEntity<RecipeDTO> addRecipe(@RequestBody RecipeDTO recipe) {
        try {
            RecipeDTO savedRecipe = recipeService.addRecipe(recipe);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedRecipe);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/recipe/{recipeId}")
    @Operation(summary = "Updates a recipe", description = "If there are any null value fields, those won't get updated")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Invalid request body: payload validation failed",
                    content = @Content(schema = @Schema(implementation = ApiError.class))),
            @ApiResponse(responseCode = "404", description = "Recipe does not exist / Category not found",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public ResponseEntity<RecipeDTO> updateRecipe(@PathVariable Integer recipeId, @RequestBody RecipeDTO recipe) {
        try {
            RecipeDTO updatedRecipe = recipeService.updateRecipe(recipeId, recipe);
            return ResponseEntity.ok(updatedRecipe);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/recipe/{recipeId}")
    @Operation(summary = "Deletes a recipe by its ID",
            description = "Deletes a recipe and all associated recipe-ingredient relationships")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "No Content"),
            @ApiResponse(responseCode = "404", description = "Recipe does not exist",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public ResponseEntity<Void> deleteRecipe(@PathVariable Integer recipeId) {
        try {
            recipeService.deleteRecipe(recipeId);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/recipes")
    @Operation(summary = "Finds all recipes")
    public ResponseEntity<List<RecipeDTO>> getAllRecipes() {
        List<RecipeDTO> recipes = recipeService.getAllRecipes();
        return ResponseEntity.ok(recipes);
    }
}
