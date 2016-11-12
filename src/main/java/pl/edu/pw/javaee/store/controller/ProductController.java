package pl.edu.pw.javaee.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.pw.javaee.store.model.Product;
import pl.edu.pw.javaee.store.service.ProductService;

import java.io.IOException;
import java.util.List;

/**
 * Created by chada on 08.11.2016.
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/productList")
        public String getProducts(Model model) {
        List<Product> products = productService.getProductList();
        model.addAttribute("products", products);

        return "products";
    }

    @RequestMapping("/viewProduct/{id}")
    public String viewProduct(@PathVariable int id, Model model) throws IOException {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);

        return "viewProduct";
    }
}
