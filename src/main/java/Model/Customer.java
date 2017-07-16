package Model;

import javax.persistence.*;

/**
 * Created by SO on 05.07.2017.
 */
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "country")
    private String country;

    public Customer() {
    }

    public Customer(String name, String country) {
       this.name = name;
       this.country = country;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        country = country;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", Name='" + name + '\'' +
                ", Country='" + country + '\'' +
                '}';
    }
}
