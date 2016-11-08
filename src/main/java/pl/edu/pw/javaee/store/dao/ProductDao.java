package pl.edu.pw.javaee.store.dao;

import pl.edu.pw.javaee.store.model.Product;

import java.util.List;

/**
 * Created by Kara on 2016-10-29.
 */
public interface ProductDao {

    void addProduct(Product product);
    Product getProductById(String id);
    List<Product> getAllProducts();
    void deleteProduct(String id);
    void editProduct(Product product);
}
