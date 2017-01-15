package pl.edu.pw.javaee.store.dao

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.annotation.Rollback
import org.springframework.test.context.ContextConfiguration
import org.springframework.transaction.annotation.Transactional
import pl.edu.pw.javaee.store.model.Customer
import pl.edu.pw.javaee.store.model.ShippingAddress
import spock.lang.Specification

import javax.validation.ConstraintViolationException

/**
 * Created by chada on 26.12.2016.
 */


@ContextConfiguration(locations = ["file:src/main/webapp/WEB-INF/applicationContext.xml",
        "file:src/main/webapp/WEB-INF/dispatcher-servlet.xml"])
class CustomerDaoTest2 extends Specification{

    @Autowired
    private CustomerDao dao

    @Transactional
    @Rollback
    def "should add customer and get by id"() {
        given:
        Customer customer = new Customer()
        ShippingAddress shippingAddress= new ShippingAddress()
        customer.setShippingAddress(shippingAddress)
        customer.setCustomerName("Imię i nazwisko2")
        customer.setUsername("username")
        customer.setPassword("password")
        customer.setCustomerEmail("email")
        when:
        dao.addCustomer(customer)
        int id = customer.getCustomerId()
        then:
        dao.getCustomerById(id)
    }

    @Transactional
    @Rollback
    def "should throw ConstraintViolationException when name, username, password or email  are not set"() {
        given:
        Customer customer = new Customer()
        ShippingAddress shippingAddress= new ShippingAddress()
        customer.setShippingAddress(shippingAddress)
        when:
        dao.addCustomer(customer)
        then:
        ConstraintViolationException ex = thrown()
    }

    @Transactional
    @Rollback
    def "should throw NullPointerException when shipping address is not set"() {
        given:
        Customer customer = new Customer()
        when:
        dao.addCustomer(customer)
        then:
        NullPointerException ex = thrown()
    }

    def "when get all customers size of list larger than 0"() {
        expect:
        dao.getAllCustomers()
    }

    @Transactional
    @Rollback
    def "should get customer by username"() {
        given:
        Customer customer = new Customer()
        ShippingAddress shippingAddress= new ShippingAddress()
        customer.setShippingAddress(shippingAddress)
        customer.setCustomerName("Imię i nazwisko2")
        customer.setUsername("login")
        customer.setPassword("password")
        customer.setCustomerEmail("email")
        when:
        dao.addCustomer(customer)
        then:
        dao.getCustomerByUsername("login")
    }

}
