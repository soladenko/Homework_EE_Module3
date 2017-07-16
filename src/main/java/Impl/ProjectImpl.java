package Impl;

import Model.Project;
import hibernateUtil.HibernateUtil;
import org.hibernate.Session;

/**
 * Created by SO on 07.07.2017.
 */
public class ProjectImpl implements DAO<Project>{


    @Override
    public void create(Project project) {

        Session session = null;
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            Integer projectID = (Integer) session.save(project);
            session.getTransaction().commit();

            project.setId(projectID);


        } catch (Exception e) {
            e.printStackTrace();

        }finally {
            if ((session !=null) && (session.isOpen())) session.close();
        }
        session.close();

    }

    @Override
    public Project read(int id) {

        Project result = null;

        Session session = null;
        try {
            session = HibernateUtil.getSession();
            result = session.find(Project.class,id);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if ((session !=null) && (session.isOpen())) session.close();
        }
        return result;

    }

    @Override
    public Project update(Project project) {


        Session session = null;
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            Project project1 = (Project) session.merge(project);
            project1.setId(project1.getId());
            System.out.println("After merge: " + project1.getName() + " " + project1.getCost());
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if ((session !=null) && (session.isOpen())) session.close();
        }
        session.close();

        return project;
    }


    @Override
    public void delete(Project project) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            session.delete(project);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if ((session !=null) && (session.isOpen())) session.close();
        }
        session.close();

    }
}
