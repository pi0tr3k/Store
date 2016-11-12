package pl.edu.pw.javaee.store.dao;

import pl.edu.pw.javaee.store.model.Product;

import java.util.List;

/**
 * Created by Kara on 2016-10-29.
 */
public interface ProductDao {

    List<Product> getProductList();

    Product getProductById(int id);

    void addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(Product product);
}
