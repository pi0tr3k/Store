package pl.edu.pw.javaee.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.pw.javaee.store.model.Customer;
import pl.edu.pw.javaee.store.model.ShippingAddress;
import pl.edu.pw.javaee.store.service.CustomerService;

import javax.validation.Valid;
import java.util.List;

/**
 * @author  Piotr Pluta
 * @version 1.0
 */
@Controller
public class RegisterController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping ("/register")
    public String registerCustomer(Model model) {
        Customer customer = new Customer();
        ShippingAddress shippingAddress = new ShippingAddress();
        customer.setShippingAddress(shippingAddress);
        model.addAttribute("customer", customer);

        return "registerCustomer";
    }

    @RequestMapping (value = "/register", method = RequestMethod.POST)
    public String registerCustomerPost(@Valid @ModelAttribute("customer") Customer customer, BindingResult result,
                                       Model model) {
        if (result.hasErrors()) {
            return "registerCustomer";
        }

        List<Customer> customerList = customerService.getAllCustomers();

        for (Customer cust: customerList) {
            if (customer.getCustomerEmail().equals(cust.getCustomerEmail())) {
                model.addAttribute("emailMsg","E-mail już istnieje");
                return "registerCustomer";
            }
            if (customer.getUsername().equals(cust.getUsername())) {
                model.addAttribute("usernameMsg","Login już istnieje");
                return "registerCustomer";
            }
        }

        customer.setEnabled(true);
        customerService.addCustomer(customer);
        return "registerCustomerSuccess";
    }
}
