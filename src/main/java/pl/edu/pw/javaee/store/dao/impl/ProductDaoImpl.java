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
 * Klasa implementująca intefejs ProductDao, pełniąca funkcję repozytorium bazodanowego.
 *
 * @author  Piotr Pluta
 * @version 1.0
 */
@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

    /**
     * Automatycznie wstrzyknięty obiekt sessionFactory.
     * Jego definicja znajduje się w pliku applicationContext.xml
     */
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Metoda dodaje produkt do bazy danych.
     * session.flush() jest odpowiednikiem Commit'a w bazie danych - dopiero po wykonaniu tej linijki kodu
     * zmiany z poziomu Javy zostaną przeniesione do świata bazodanowego
     *
     * @param product
     */
    public void addProduct(Product product){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }

    /**
     * Metoda przyjmuje jako parametr id produktu, następnie wyszukuje w sesji produkt o tym id i go zwraca.
     *
     * @param id
     * @return product
     */
    public Product getProductById (long id){
        Session session = sessionFactory.getCurrentSession();
        Product product = (Product) session.get(Product.class, id);
        session.flush();
        return product;
    }

    /**
     * Metoda usuwająca z bazy danych rekord odpowiadający przekazanemu produktowi.
     *
     * @param product
     */
    public void deleteProduct (Product product){
        Session session = sessionFactory.getCurrentSession();
        session.delete(product);
        session.flush();
    }

    /**
     * Metoda zwraca listę wszystkich produktów z bazy danych.
     *
     * @return product
     */
    public List<Product> getProductList(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product");
        List<Product> products = query.list();
        session.flush();

        return products;
    }

    /**
     * Metoda zwraca listę produktów powiązanych z kategorią tenisa ziemnego
     *
     * @return products
     */
    public List<Product> getTennisProducts() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product where productCategory = ?");
        query.setString(0, "Tenis ziemny");
        List<Product> products = query.list();
        session.flush();

        return products;
    }

    /**
     * Metoda zwraca listę produktów powiązanych z kategorią tenisa stołowego.
     *
     * @return products
     */
    public List<Product> getTableTennisProducts() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product where productCategory = ?");
        query.setString(0, "Tenis stołowy");
        List<Product> products = query.list();
        session.flush();

        return products;
    }

    /**
     * Metoda zwraca listę produktów powiązanych z kategorią "Ubrania i akcesoria"
     *
     * @return products
     */
    public List<Product> getClothesProducts() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product where productCategory = ?");
        query.setString(0, "Ubrania i akcesoria");
        List<Product> products = query.list();
        session.flush();

        return products;
    }

    /**
     * Metoda pozwala edytować istniejący produkt produktem podanym w argumencie.
     *
     * @param product
     */
    public void editProduct(Product product){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }

}
