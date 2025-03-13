package guru.springframework.spring5webapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;
import java.util.Set;

@Entity
public class Publisher {

    @Id //Como va a ser una entidad necesitamos una pk
    @GeneratedValue(strategy = GenerationType.AUTO) //La forma de generar la pk
    private  Long id;
    private String name;
    private String adressLine1;
    private String city;
    private String state;
    private String zip;

    //Constructors
    public Publisher() {}
    public Publisher(String name, String adressLine1, String city, String state, String zip) {
        this.name = name;
        this.adressLine1 = adressLine1;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    //Getters
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getAdress() {
        return adressLine1 + " " + city + " " + state + " " + zip;
    }

    //Setters
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAdress(String adress) {
        this.adressLine1 = adress;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setState(String state) {
        this.state = state;
    }
    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publisher publisher = (Publisher) o;

        return id != null ? id.equals(publisher.id) : publisher.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }


    //ToString

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", adressLine1='" + adressLine1 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }

}

/*
Injeccion de dependencia:
    1) Atributo
    2) Set
    3) Constructor (Recomendable)
        Mejor que @autowire
 */