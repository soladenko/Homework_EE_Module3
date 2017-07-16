package service;

import Impl.DAO;
import Impl.ProjectImpl;
import Model.Project;

/**
 * Created by SO on 07.07.2017.
 */
public class ServiceProject {

    private DAO<Project> projectDAO;

    public ServiceProject() {
        projectDAO = new ProjectImpl();
    }

    public void create(Project project) {
        System.out.println("=====CREATE======");
        projectDAO.create(project);
        System.out.println("Created:" + project);
    }
    public Project read(int id) {
        System.out.println("=============READ=============");
        Project readProject = projectDAO.read(id);
        projectDAO.read(id);
        System.out.println(readProject);
        return readProject;
    }
    public void updateProject(int id) {
        System.out.println("======UPDATE=====");
        Project currentProject = new Project("10G in Ukraine",5000000);
        currentProject.setId(id);
        Project newProject = projectDAO.update(currentProject);
        System.out.println(newProject);
    }
    public void deleteProject(Project project) {
        System.out.println("======DELETE=====");
        projectDAO.delete(project);
        System.out.println("deleted company with id:" + project);
    }
}
