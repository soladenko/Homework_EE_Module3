package Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by SO on 05.07.2017.
 */
@Entity
@Table(name = "skills")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
    @JoinTable(name = "developers_skills",
            joinColumns = @JoinColumn(name = "developer_id")
            ,inverseJoinColumns = @JoinColumn(name = "skill_id"))

    Set<Developer> developers = new HashSet<>();

    public Skill() {
    }
    public static Skill getSkill (){
        Skill skill = new Skill("France languige" + new Random());
        return  skill;
    }



    public Skill(String name) {
       this.name = name;
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
        name = name;
    }

    public Set<Developer> getDevelopers() {
        return developers;
    }


    public void setDevelopers(Set<Developer> developers) {
        this.developers = developers;
    }


    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", developers=" + developers +
                '}';
    }
}

