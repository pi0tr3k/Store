package pl.edu.pw.javaee.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by chada on 08.11.2016.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "welcome";
    }

    @RequestMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout, Model model){
        if (error != null) {
            model.addAttribute("error", "Nieprawidłowy login lub hasło");
        }
        if (logout != null) {
            model.addAttribute("logout", "Zostałeś pomyślnie wylogowany.");
        }
        return "login";
    }
}
