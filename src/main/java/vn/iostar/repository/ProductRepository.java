package vn.iostar.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.iostar.entity.Category;
import vn.iostar.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	 List<Product> findAllByOrderByPriceAsc();
	 List<Product> findByCategory(Category category);
}