package pl.edu.pw.javaee.store.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.pw.javaee.store.dao.ProductDao;
import pl.edu.pw.javaee.store.model.Product;

import java.util.List;

/**
 * Created by Kara on 2016-10-29.
 */
@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addProduct(Product product){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }

    public Product getProductById (long id){
        Session session = sessionFactory.getCurrentSession();
        Product product = (Product) session.get(Product.class, id);
        session.flush();
        return product;
    }

    public void deleteProduct (Product product){
        Session session = sessionFactory.getCurrentSession();
        session.delete(product);
        session.flush();
    }

    public List<Product> getProductList(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product");
        List<Product> products = query.list();
        session.flush();

        return products;
    }

    public List<Product> getTennisProducts() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product where productCategory = ?");
        query.setString(0, "Tenis ziemny");
        List<Product> products = query.list();
        session.flush();

        return products;
    }

    public List<Product> getTableTennisProducts() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product where productCategory = ?");
        query.setString(0, "Tenis stołowy");
        List<Product> products = query.list();
        session.flush();

        return products;
    }

    public List<Product> getClothesProducts() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product where productCategory = ?");
        query.setString(0, "Ubrania i akcesoria");
        List<Product> products = query.list();
        session.flush();

        return products;
    }

    public void editProduct(Product product){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }

}
