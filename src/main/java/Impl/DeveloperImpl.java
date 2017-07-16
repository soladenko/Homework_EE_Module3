package Impl;

import Model.Developer;
import hibernateUtil.HibernateUtil;
import org.hibernate.Session;




public class DeveloperImpl implements DAO<Developer> {
    @Override
    public void create(Developer developer) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            Integer developerId = (Integer) session.save(developer);
            session.getTransaction().commit();

            developer.setId(developerId);


        } catch (Exception e) {
            e.printStackTrace();

        }finally {
            if ((session !=null) && (session.isOpen())) session.close();
        }
        session.close();
    }

    @Override
    public Developer read(int id) {
        Developer result = null;

        Session session = null;
        try {
            session = HibernateUtil.getSession();
            result = session.find(Developer.class,id);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if ((session !=null) && (session.isOpen())) session.close();
        }
        return result;
    }


    @Override
    public Developer update(Developer developer) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            Developer developer1 = (Developer) session.merge(developer);
            developer1.setId(developer1.getId());
            System.out.println("After merge: " + developer1.getName() + " " + developer1.getSurname() + " " +  developer1.getAge() + " " + developer1.getSalary());
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if ((session !=null) && (session.isOpen())) session.close();
        }
        session.close();

        return developer;
    }

    @Override
    public void delete(Developer developer) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            session.delete(developer);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if ((session !=null) && (session.isOpen())) session.close();
        }
        session.close();
    }
}

