package pl.edu.pw.javaee.store.domain.repository;

import pl.edu.pw.javaee.store.domain.product.model.Product;

import java.util.List;

/**
 * Created by Kara on 2016-10-15.
 */
public interface ProductRepository {

    List<Product> getAllProducts();

    Product getProductById(String productID);
}
