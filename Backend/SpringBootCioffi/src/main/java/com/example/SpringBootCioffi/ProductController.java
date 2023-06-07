package com.example.SpringBootCioffi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ProductController {
    private  ProductRepository productRepository;
    //Injects a portion into the ProductController class for database manipulation
    @Autowired
    public ProductController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @GetMapping("/getList")
    public String listProduct(Model model){
        List<Product> list = productRepository.findAll();
        model.addAttribute("ProductList", list);
        return "ListProduct";
    }
    @GetMapping("/create")
    public String insertProduct(Model model){
        model.addAttribute("Product", new Product());
        return "NewProduct";
    }
    @PostMapping("/create")
    public String addProduct(@ModelAttribute Product product, Model model){
        productRepository.save(product);
        listProduct(model);
        return "ListProduct";
    }
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id, Model model){
        productRepository.deleteById(id);
        listProduct(model);
        return "ListProduct";
    }
    @GetMapping("/update/{id}")
    public String updateProduct(@PathVariable Long id, Model model){
        Product product = productRepository.findById(id).get();
        model.addAttribute("Product", product);
        return "UpdateProduct";
    }
    @PostMapping("/update/{id}")
    public String updateProduct(@ModelAttribute Product product, Model model){
        productRepository.save(product);
        listProduct(model);
        return "ListProduct";
    }
}
