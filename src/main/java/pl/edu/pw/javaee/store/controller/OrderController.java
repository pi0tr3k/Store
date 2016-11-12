package pl.edu.pw.javaee.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.pw.javaee.store.model.Cart;
import pl.edu.pw.javaee.store.model.Customer;
import pl.edu.pw.javaee.store.model.CustomerOrder;
import pl.edu.pw.javaee.store.service.CartService;
import pl.edu.pw.javaee.store.service.CustomerOrderService;

/**
 * Created by chada on 11.11.2016.
 */
@Controller
public class OrderController {

    @Autowired
    private CartService cartService;
    @Autowired
    private CustomerOrderService customerOrderService;

    @RequestMapping("/order/{cartId}")
    public String createOrder(@PathVariable("cartId") long cartId) {
        CustomerOrder customerOrder = new CustomerOrder();
        Cart cart = cartService.getCartById(cartId);
        customerOrder.setCart(cart);

        Customer customer = cart.getCustomer();
        customerOrder.setCustomer(customer);
        customerOrder.setBillingAddress(customer.getBillingAddress());
        customerOrder.setShippingAddress(customer.getShippingAddress());

        customerOrderService.addCustomerOrder(customerOrder);

        return "redirect:/checkout?cartId="+cartId;
    }
}
