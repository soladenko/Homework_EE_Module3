package service;

import Impl.DAO;
import Impl.DeveloperImpl;
import Model.Developer;
import Model.Skill;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import static Model.Developer.getDeveloper;
import static Model.Skill.getSkill;
import static service.ServiceSkill.skillDAO;

/**
 * Created by SO on 06.07.2017.
 */
public class ServiceDeveloper {


    public static DAO<Developer> developerDAO;

    public ServiceDeveloper() {
        developerDAO = new DeveloperImpl();
    }

    public void create(Developer developer) {
        System.out.println("=====CREATE======");
        developerDAO.create(developer);
        System.out.println("Created:" + developer);
    }

    public Developer read(int id) {
        System.out.println("=============READ=============");
        Developer readDeveloper = developerDAO.read(id);
        developerDAO.read(id);
        System.out.println(readDeveloper);
        return readDeveloper;
    }

    public void updateDeveloper(int id) {
        System.out.println("======UPDATE=====");
        Developer currentDeveloper = new Developer("Ivan", "Ivanov", 33, 3333);
        currentDeveloper.setId(id);
        Developer newDeveloper = developerDAO.update(currentDeveloper);
        System.out.println(newDeveloper);
    }

    public void deleteDeveloper(Developer developer) {
        System.out.println("======DELETE=====");
        developerDAO.delete(developer);
        System.out.println("deleted developer with id:" + developer);
    }



    public static Developer getDeveloperSkills() {

        Developer developer = getDeveloper();
        Set<Skill>skills = new HashSet<>();
        for (int i = 0; i <3 ; i++) {
            skills.add(getSkill());
            developer.setSkills(skills);

        }
        return developer;
    }
    public static void createDeveloperWithSkills(){
        for (Skill skill: getDeveloper().getSkills()) {
            skillDAO.create(skill);
        }




        }




    }

















