package pl.edu.pw.javaee.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.pw.javaee.store.domain.repository.ProductRepository;

/**
 * Created by Kara on 2016-10-15.
 */
@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping("/products")
    public String list(Model model) {
        model.addAttribute("products", productRepository.getAllProducts());
        return "products";
    }



}
