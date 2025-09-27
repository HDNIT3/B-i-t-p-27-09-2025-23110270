package vn.iostar.controller;

import java.util.List;

import org.springframework.stereotype.Controller;

import vn.iostar.entity.Product;
import vn.iostar.service.ProductService;
import org.springframework.graphql.data.method.annotation.*;
@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // --- Query ---
    @QueryMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @QueryMapping
    public Product getProductById(@Argument Long id) {
        return productService.getProductById(id);
    }

    // --- Mutation ---
    @MutationMapping
    public Product createProduct(@Argument Product product) {
        return productService.createProduct(product);
    }

    @MutationMapping
    public Product updateProduct(@Argument Long id, @Argument Product product) {
        return productService.updateProduct(id, product);
    }

    @MutationMapping
    public boolean deleteProduct(@Argument Long id) {
        return productService.deleteProduct(id);
    }
    
    @QueryMapping
    public List<Product> getAllProductsSortedByPrice() {
        return productService.getAllProductsSortedByPrice();
    }

    @QueryMapping
    public List<Product> getProductsByCategory(@Argument Long categoryId) {
        return productService.getProductsByCategory(categoryId);
    }
}
