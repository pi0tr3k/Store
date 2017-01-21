package pl.edu.pw.javaee.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.pw.javaee.store.model.Customer;
import pl.edu.pw.javaee.store.service.CustomerService;

/**
 * @author  Piotr Pluta
 * @version 1.0
 */
@Controller
@RequestMapping("/customer/cart")
public class CartController {

    @Autowired
    CustomerService customerService;

    @RequestMapping
    public String getCart(@AuthenticationPrincipal User activeUser){
        Customer customer = customerService.getCustomerByUsername(activeUser.getUsername());
        long cartId = customer.getCart().getCartId();

        return "redirect:/customer/cart/"+cartId;
    }

    @RequestMapping("/{cartId}")
    public String getCartRedirect(@PathVariable (value = "cartId") long cartId, Model model) {
        model.addAttribute("cartId", cartId);

        return "cart";
    }
}
