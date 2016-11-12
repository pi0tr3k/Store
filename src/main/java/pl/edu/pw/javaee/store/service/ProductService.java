package pl.edu.pw.javaee.store.service;

import pl.edu.pw.javaee.store.model.Product;

import java.util.List;

/**
 * Created by chada on 08.11.2016.
 */
public interface ProductService {

    List<Product> getProductList();

    Product getProductById(int id);

    void addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(Product product);
}
