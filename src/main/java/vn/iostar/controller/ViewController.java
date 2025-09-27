package vn.iostar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/products-view")
    public String showProducts() {
        return "Products"; // trỏ tới products.html trong templates
    }
}
