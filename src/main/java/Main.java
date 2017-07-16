import Model.*;
import hibernateUtil.HibernateUtil;
import service.*;
import Impl.SkillImpl;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by SO on 03.07.2017.
 */
public class Main {
    public static void main(String[] args) {


        //Session sessionFactory = HibernateUtil.getSession();


        Developer developer = new Developer("Michael", "Smirnov", 22, 22222222);

        ServiceDeveloper serviceDeveloper = new ServiceDeveloper();
        serviceDeveloper.create(developer);
        serviceDeveloper.read(developer.getId());
        serviceDeveloper.updateDeveloper(developer.getId());
        serviceDeveloper.deleteDeveloper(developer);


        Company company = new Company("ZORRO");

        ServiceCompany serviceCompany = new ServiceCompany();
        serviceCompany.create(company);
        serviceCompany.read(company.getId());
        serviceCompany.updateCompany(company.getId());
        serviceCompany.deleteCompany(company);


        Skill skill = new Skill("Play_gitare");

        ServiceSkill serviceSkill = new ServiceSkill();
        serviceSkill.create(skill);
        serviceSkill.read(skill.getId());
        serviceSkill.updateSkill(skill.getId());
        serviceSkill.deleteSkill(skill);


        Project project = new Project("SWAP 3Mob", 100000000);

        ServiceProject serviceProject = new ServiceProject();
        serviceProject.create(project);
        serviceProject.read(project.getId());
        serviceProject.updateProject(project.getId());
        serviceProject.deleteProject(project);



        Customer customer = new Customer("Apple", "USA");


        ServiceCustomer serviceCustomer = new ServiceCustomer();
        serviceCustomer.create(customer);
        serviceCustomer.read(customer.getId());
        serviceCustomer.updateCustomer(customer.getId());
        serviceCustomer.deleteCustomer(customer);


        serviceDeveloper.create(Developer.getDeveloper());





        HibernateUtil.shutDown();

    }
}











