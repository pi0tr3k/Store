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

    @RequestMapping("/productList/tennis")
    public String getTennisProducts(Model model) {
        List<Product> products = productService.getTennisProducts();
        model.addAttribute("products", products);

        return "productsTennis";
    }

    @RequestMapping("/productList/clothes")
    public String getClothesProducts(Model model) {
        List<Product> products = productService.getClothesProducts();
        model.addAttribute("products", products);

        return "productsClothes";
    }

    @RequestMapping("/productList/tableTennis")
    public String getTableTennisProducts(Model model) {
        List<Product> products = productService.getTableTennisProducts();
        model.addAttribute("products", products);

        return "productsTableTennis";
    }

    @RequestMapping("/viewProduct/{id}")
    public String viewProduct(@PathVariable long id, Model model) throws IOException {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);

        return "viewProduct";
    }
}
