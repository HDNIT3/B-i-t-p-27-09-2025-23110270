package vn.iostar.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.iostar.entity.Product;
import vn.iostar.repository.ProductRepository;
import vn.iostar.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return productRepository.findById(id).map(p -> {
            p.setTitle(product.getTitle());
            p.setQuantity(product.getQuantity());
            p.setDesc(product.getDesc());
            p.setPrice(product.getPrice());
            p.setUser(product.getUser());
            p.setCategory(product.getCategory());
            return productRepository.save(p);
        }).orElse(null);
    }

    @Override
    public boolean deleteProduct(Long id) {
        if(productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
