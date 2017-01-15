package pl.edu.pw.javaee.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.pw.javaee.store.dao.CustomerOrderItemDao;
import pl.edu.pw.javaee.store.model.*;
import pl.edu.pw.javaee.store.service.CartService;
import pl.edu.pw.javaee.store.service.CustomerOrderService;
import pl.edu.pw.javaee.store.service.CustomerService;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chada on 11.11.2016.
 */
@Controller
public class OrderController {

    @Autowired
    private CartService cartService;
    @Autowired
    private CustomerOrderService customerOrderService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerOrderItemDao customerOrderItemDao;

    @RequestMapping("/order/{cartId}")
    public String createOrder(@PathVariable("cartId") long cartId) {
        CustomerOrder customerOrder = new CustomerOrder();
        Cart cart = cartService.getCartById(cartId);
        customerOrder.setCart(cart);
        customerOrder.setShippingAddress(cart.getCustomer().getShippingAddress());
        customerOrder.setCustomerName(cart.getCustomer().getCustomerName());
        customerOrderService.addCustomerOrder(customerOrder);

        for (CartItem cartItem: cart.getCartItems()) {
            CustomerOrderItem customerOrderItem = new CustomerOrderItem();
            customerOrderItem.setProduct(cartItem.getProduct());
            customerOrderItem.setQuantity(cartItem.getQuantity());
            customerOrderItem.setCustomerOrder(customerOrder);
            customerOrderItemDao.addCustomerOrderItem(customerOrderItem);
        }


        return "redirect:/checkout?orderId="+customerOrder.getCustomerOrderId();
    }

    @RequestMapping("/viewOrder/{id}")
    public String viewOrder(@PathVariable long id, Model model) throws IOException {
        CustomerOrder order = customerOrderService.getOrderById(id);
        List<CustomerOrderItem> orderItems = customerOrderItemDao.getCustomerOrderItemListByOrderId(id);
        model.addAttribute("order", order);
        model.addAttribute("orderItems", orderItems);

        return "viewOrder";
    }
}
