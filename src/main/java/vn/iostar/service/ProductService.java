package vn.iostar.service;

import java.util.List;

import vn.iostar.entity.Product;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product createProduct(Product product);
    Product updateProduct(Long id, Product product);
    boolean deleteProduct(Long id);
	List<Product> getAllProductsSortedByPrice();
	List<Product> getProductsByCategory(Long categoryId);
}