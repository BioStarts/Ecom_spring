package com.geekbrains.controllers;

import com.geekbrains.entities.Product;
import com.geekbrains.entities.Student;
import com.geekbrains.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
// http://localhost:8189/app/products/...
@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) { this.productService = productService; }

    // http://localhost:8189/app/products/show
    @RequestMapping(path = "/show", method = RequestMethod.GET)
    public String showAllProducts(Model model){
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "all_products";
    }

    // http://localhost:8189/app/products/info/1
    @RequestMapping(path = "/info/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Product getProductById(@PathVariable Long id) {
        return productService.findById(id).orElseThrow(() -> new RuntimeException());
    }

    @RequestMapping("/info_by")
    public String processForm() {
        return "info_by_id";
    }

    @GetMapping(path = "/infoid")
    @ResponseBody
    public Product getProductById2(@RequestParam (value = "id") Long id) {
        return productService.findById(id).orElseThrow(() -> new RuntimeException());
    }

    @RequestMapping("/create_product")
    public String processCreate() {
        return "add_product";
    }

    @GetMapping(path = "/adding_product")
    @ResponseBody
    public String addProduct(@RequestParam (value = "id") Long id, @RequestParam (value = "title") String title, @RequestParam (value = "price") BigDecimal price) {
         productService.insert(new Product(id,title,price));
        {return "/redirect:/";}
    }


}
