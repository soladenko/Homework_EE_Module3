package service;

import Impl.CustomerImpl;
import Impl.DAO;
import Model.Customer;

/**
 * Created by SO on 07.07.2017.
 */
public class ServiceCustomer {

    private DAO<Customer> customerDAO;

    public ServiceCustomer() {
        customerDAO = new CustomerImpl();
    }

    public void create(Customer customer) {
        System.out.println("=====CREATE======");
        customerDAO.create(customer);
        System.out.println("Created:" + customer);
    }
    public Customer read(int id) {
        System.out.println("=============READ=============");
        Customer readCustomer = customerDAO.read(id);
        customerDAO.read(id);
        System.out.println(readCustomer);
        return readCustomer;
    }
    public void updateCustomer(int id) {
        System.out.println("======UPDATE=====");
        Customer currentCustomer = new Customer("Microsoft","USA");
        currentCustomer.setId(id);
        Customer newCastomer = customerDAO.update(currentCustomer);
        System.out.println(newCastomer);
    }
    public void deleteCustomer(Customer customer) {
        System.out.println("======DELETE=====");
        customerDAO.delete(customer);
        System.out.println("deleted customer with id:" + customer);
    }

}
