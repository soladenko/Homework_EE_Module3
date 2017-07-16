package Impl;

import Model.Company;
import Model.Developer;
import hibernateUtil.HibernateUtil;
import org.hibernate.Session;

/**
 * Created by SO on 06.07.2017.
 */
public class CompanyImpl implements DAO<Company>{

    @Override
    public void create(Company company) {
            Session session = null;
            try {
                session = HibernateUtil.getSession();
                session.beginTransaction();
                Integer companyId = (Integer) session.save(company);
                session.getTransaction().commit();

                company.setId(companyId);


            } catch (Exception e) {
                e.printStackTrace();

            }finally {
                if ((session !=null) && (session.isOpen())) session.close();
            }
            session.close();
        }



    @Override
    public Company read(int id) {
        Company result = null;

    Session session = null;
        try {
        session = HibernateUtil.getSession();
        result = session.find(Company.class,id);

    } catch (Exception e) {
        e.printStackTrace();
    }finally {
        if ((session !=null) && (session.isOpen())) session.close();
    }
        return result;

}

    @Override
    public Company update(Company company) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            Company company1 = (Company) session.merge(company);
            company1.setId(company1.getId());
            System.out.println("After merge: " + company1.getName());
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if ((session !=null) && (session.isOpen())) session.close();
        }
        session.close();

        return company;
    }



    @Override
    public void delete(Company company) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            session.delete(company);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if ((session !=null) && (session.isOpen())) session.close();
        }
        session.close();

    }
}
