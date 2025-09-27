package vn.iostar.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.graphql.data.method.annotation.*;

import vn.iostar.entity.Category;
import vn.iostar.service.CategoryService;

@Controller
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // --- Query ---
    @QueryMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @QueryMapping
    public Category getCategoryById(@Argument Long id) {
        return categoryService.getCategoryById(id);
    }

    // --- Mutation ---
    @MutationMapping
    public Category createCategory(@Argument Category category) {
        return categoryService.createCategory(category);
    }

    @MutationMapping
    public Category updateCategory(@Argument Long id, @Argument Category category) {
        return categoryService.updateCategory(id, category);
    }

    @MutationMapping
    public boolean deleteCategory(@Argument Long id) {
        return categoryService.deleteCategory(id);
    }
}