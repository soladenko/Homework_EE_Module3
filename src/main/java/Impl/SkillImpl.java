package Impl;

import Impl.DAO;
import Model.Skill;
import hibernateUtil.HibernateUtil;
import org.hibernate.Session;

/**
 * Created by SO on 06.07.2017.
 */
public class SkillImpl implements DAO<Skill>{


    @Override
    public void create(Skill skill) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            Integer skillId = (Integer) session.save(skill);
            session.getTransaction().commit();

            skill.setId(skillId);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if ((session !=null) && (session.isOpen())) session.close();
        }
        session.close();

    }

    @Override
    public Skill read(int id) {

        Skill result = null;

        Session session = null;
        try {
            session = HibernateUtil.getSession();
            result = session.find(Skill.class,id);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if ((session !=null) && (session.isOpen())) session.close();
        }
        return result;

    }

    @Override
    public Skill update(Skill skill) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            Skill skill1 = (Skill) session.merge(skill);
            skill1.setId(skill1.getId());
            System.out.println("After merge: " + skill1.getName());
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if ((session !=null) && (session.isOpen())) session.close();
        }
        session.close();

        return skill;


    }

    @Override
    public void delete(Skill skill) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            session.delete(skill);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if ((session !=null) && (session.isOpen())) session.close();
        }
        session.close();



    }
}
