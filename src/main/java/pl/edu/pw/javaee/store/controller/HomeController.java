package pl.edu.pw.javaee.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Kara on 2016-10-16.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String welcome(Model model) {
        model.addAttribute("greeting", "Witaj w sklepie internetowym!");
        model.addAttribute("tagline", "Wyjątkowym i jedynym sklepie internetowym");

        return "welcome";
    }
}
