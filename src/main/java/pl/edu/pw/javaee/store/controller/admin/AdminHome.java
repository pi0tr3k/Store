package pl.edu.pw.javaee.store.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.pw.javaee.store.model.Customer;
import pl.edu.pw.javaee.store.model.Product;
import pl.edu.pw.javaee.store.service.CustomerService;
import pl.edu.pw.javaee.store.service.ProductService;

import java.util.List;

/**
 * Created by chada on 08.11.2016.
 */
@Controller
@RequestMapping("/admin")
public class AdminHome {

    @Autowired
    private ProductService productService;
    @Autowired
    private CustomerService customerService;

    @RequestMapping
    public String adminPage() {
        return "admin";
    }

    @RequestMapping("/productInventory")
    public String productInventory(Model model) {
        List<Product> products = productService.getProductList();
        model.addAttribute("products", products);

        return "productInventory";
    }

    @RequestMapping("/customer")
    public String customerManagment(Model model) {
        List<Customer> customerList = customerService.getAllCustomers();
        model.addAttribute("customerList", customerList);
        return "customerManagment";
    }
}
