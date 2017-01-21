package pl.edu.pw.javaee.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Klasa traktowana jako Kontroler we frameworku Model-Widok-Kontroler.
 * Odpowiada więc za komunikację pomiędzy modelem danych a widokiem.
 *
 * @author  Karolina Chadaj
 * @version 1.0
 */
@Controller
public class HomeController {

    /**
     * Gdy pojawi się żądanie HTTP, wskazujące jako ścieżkę "root"
     * zostanie automatycznie zmapowane na metodę home().
     * Zwrócona zostaje wartość tekstowa, która zostanie później użyta prez
     * ViewResolver do znalezienia odpowiedniego pliku .jsp z widokiem (w tym przypadku home.jsp)
     *
     * @return String - Zwracany jest tekst "welcome"
     */
    @RequestMapping("/")
    public String home() {
        return "welcome";
    }

    /**
     * Gdy pojawi się żądanie HTTP, wskazujące jako ścieżkę "/login"
     * zostanie automatycznie zmapowane na metodę login().
     * Xwrócona zostaje wartość tekstowa, która zostanie później użyta prez
     * ViewResolver do znalezienia odpowiedniego pliku .jsp z widokiem (w tym przypadku login.jsp).
     * Dodatkowo w przypadku wystąpienia błędu logowania lub po poprawnym wylogowaniu się użytkownika,
     * zostanie on poinformowany o tym fakcie.
     *
     * @return String - Zwracany jest tekst "login"
     */
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
