package Impl;

import Model.Customer;
import hibernateUtil.HibernateUtil;
import org.hibernate.Session;

/**
 * Created by SO on 07.07.2017.
 */
public class CustomerImpl implements DAO<Customer>{


    @Override
    public void create(Customer customer) {

        Session session = null;
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            Integer customerID = (Integer) session.save(customer);
            session.getTransaction().commit();

            customer.setId(customerID);


        } catch (Exception e) {
            e.printStackTrace();

        }finally {
            if ((session !=null) && (session.isOpen())) session.close();
        }
        session.close();

    }

    @Override
    public Customer read(int id) {

        Customer result = null;

        Session session = null;
        try {
            session = HibernateUtil.getSession();
            result = session.find(Customer.class,id);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if ((session !=null) && (session.isOpen())) session.close();
        }
        return result;
}

    @Override
    public Customer update(Customer customer) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            Customer customer1 = (Customer) session.merge(customer);
            customer1.setId(customer1.getId());
            System.out.println("After merge: " + customer1.getName() + " " + customer1.getCountry());
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if ((session !=null) && (session.isOpen())) session.close();
        }
        session.close();

        return customer;
    }


    @Override
    public void delete(Customer customer) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            session.delete(customer);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if ((session !=null) && (session.isOpen())) session.close();
        }
        session.close();



    }
}
