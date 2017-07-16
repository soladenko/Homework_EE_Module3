package Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by SO on 05.07.2017.
 */
@Entity
@Table(name = "developers")
public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name",length = 50)
    private String name;

    @Column(name = "surname",length = 50)
    private String surname;

    @Column(name = "age")
    private int age;

    @Column(name = "salary")
    private int salary;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "developers")
    private Set<Skill> skills = new HashSet<>();


    public Developer() {
    }

    public Developer(String name, String surname, int age, int salary) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.salary = salary;
    }
    public  static Developer getDeveloper(){
        Developer developer = new Developer();
        developer.setName("Alex");
        developer.setSurname("Roze");
        developer.setAge(22);
        developer.setSalary(10000);

        developer.setName("Andrey");
        developer.setSurname("Minov");
        developer.setAge(35);
        developer.setSalary(2000);
        return developer;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", developerSkills=" + skills +
                '}';
    }
}
