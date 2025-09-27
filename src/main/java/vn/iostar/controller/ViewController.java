package vn.iostar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/products-view")
    public String showProducts() {
        return "Products";
    }
    
    @GetMapping("/crud_user")
    public String crud_user() {
        return "users";
    }
    
    @GetMapping("/crud_cate")
    public String cate() {
        return "categories";
    }
    
    @GetMapping("/productss")
    public String showProductsss() {
        return "productss";
    }
}
