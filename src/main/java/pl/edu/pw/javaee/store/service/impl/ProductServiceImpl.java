package pl.edu.pw.javaee.store.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pw.javaee.store.dao.ProductDao;
import pl.edu.pw.javaee.store.model.Product;
import pl.edu.pw.javaee.store.service.ProductService;

import java.util.List;

/**
 * @author  Piotr Pluta
 * @version 1.0
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    public Product getProductById(long id) {
        return productDao.getProductById(id);
    }

    public List<Product> getProductList() {
        return productDao.getProductList();
    }

    public List<Product> getTennisProducts() {return productDao.getTennisProducts();}

    public List<Product> getTableTennisProducts() {return productDao.getTableTennisProducts();}

    public List<Product> getClothesProducts() {return productDao.getClothesProducts();}

    public void  addProduct(Product product) {
        productDao.addProduct(product);
    }

    public void editProduct(Product product) {
        productDao.editProduct(product);
    }

    public void deleteProduct(Product product) {
        productDao.deleteProduct(product);
    }
}
