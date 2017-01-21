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
 * Klasa traktowana jako Kontroler we frameworku Model-Widok-Kontroler.
 * Odpowiada więc za komunikację pomiędzy modelem danych a widokiem.
 *
 * @author  Piotr Pluta
 * @version 1.0
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    /**
     * Pobierana jest lista produktów z obiektu klasy ProductService.
     * Następnie metoda wiąże listę produktów z modelem.
     * Zwracając tekst "productsTennis", widok productsTennis.jsp będzie automatycznie powiązany z modelem.
     * W widoku productsTennis.jsp możemy więc użyć wyrażenia ${products}
     */
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

    /**
     * W nawiasie klamrowym adnotacja @RequestMapping określa @PathVariable
     * Tym razem prócz modelu, metoda przyjmuje jako parametr zmienną odczytaną z adresu ścieżki.
     * Trafia ona do parametru o nazwie id. Następnie pobierany jest produkt o tym id, który dalej
     * zostaje powiązany z widokiem viewProduct.jsp
     */
    @RequestMapping("/viewProduct/{id}")
    public String viewProduct(@PathVariable long id, Model model) throws IOException {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);

        return "viewProduct";
    }
}
