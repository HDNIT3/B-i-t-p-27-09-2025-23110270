package vn.iostar.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.iostar.entity.Category;
import vn.iostar.repository.CategoryRepository;
import vn.iostar.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Long id, Category category) {
        return categoryRepository.findById(id).map(c -> {
            c.setName(category.getName());
            c.setImages(category.getImages());
            return categoryRepository.save(c);
        }).orElse(null);
    }

    @Override
    public boolean deleteCategory(Long id) {
        if(categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
