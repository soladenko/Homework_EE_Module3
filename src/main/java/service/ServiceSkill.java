package service;

import Impl.DAO;
import Impl.SkillImpl;
import Model.Skill;

/**
 * Created by SO on 06.07.2017.
 */
public class ServiceSkill {
    public static DAO<Skill> skillDAO;

    public ServiceSkill() {
        skillDAO = new SkillImpl();
    }

    public void create(Skill skill) {
        System.out.println("=====CREATE======");
        skillDAO.create(skill);
        System.out.println("Created:" + skill);
    }
    public Skill read(int id) {
        System.out.println("=============READ=============");
        Skill readSkill = skillDAO.read(id);
        skillDAO.read(id);
        System.out.println(readSkill);
        return readSkill;
    }
    public void updateSkill(int id) {
        System.out.println("======UPDATE=====");
        Skill currentSkill = new Skill("Play football");
        currentSkill.setId(id);
        Skill newSkill = skillDAO.update(currentSkill);
        System.out.println(newSkill);
    }
    public void deleteSkill(Skill skill) {
        System.out.println("======DELETE=====");
        skillDAO.delete(skill);
        System.out.println("deleted skill with id:" + skill);
    }

}
