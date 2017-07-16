package service;

import Impl.CompanyImpl;
import Impl.DAO;
import Impl.DeveloperImpl;
import Model.Company;
import Model.Developer;

/**
 * Created by SO on 06.07.2017.
 */
public class ServiceCompany {
    private DAO<Company> companyDAO;

    public ServiceCompany() {
        companyDAO = new CompanyImpl();
    }

    public void create(Company company) {
        System.out.println("=====CREATE======");
        companyDAO.create(company);
        System.out.println("Created:" + company);
    }
    public Company read(int id) {
        System.out.println("=============READ=============");
        Company readCompany = companyDAO.read(id);
        companyDAO.read(id);
        System.out.println(readCompany);
        return readCompany;
    }
    public void updateCompany(int id) {
        System.out.println("======UPDATE=====");
        Company currentCompany = new Company("Petya");
        currentCompany.setId(id);
        Company newCompany = companyDAO.update(currentCompany);
        System.out.println(newCompany);
    }
    public void deleteCompany(Company company) {
        System.out.println("======DELETE=====");
        companyDAO.delete(company);
        System.out.println("deleted company with id:" + company);
    }

}
