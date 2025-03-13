package guru.springframework.spring5webapp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Publisher {

    @Id //Como va a ser una entidad necesitamos una pk
    @GeneratedValue(strategy = GenerationType.AUTO) //La forma de generar la pk
    private Long id;
    private String name;
    private String adressLine1;
    private String city;
    private String state;
    private String zip;

    @OneToMany //1 Publisher = Many Books
    @JoinColumn(name = "publisher_id")
    /*Le da el conocimiento a hibernate q con esto se hace la FK*/
    private Set<Book> books = new HashSet<>();

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
    public String getAdressLine1() {
        return adressLine1;
    }
    public String getCity() {
        return city;
    }
    public String getState() {
        return state;
    }
    public String getZip() {
        return zip;
    }
    public Set<Book> getBooks() {
        return books;
    }

    //Setters
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
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
    public void setBooks(Set<Book> books) {
        this.books = books;
    }
    public void setAdressLine1(String adressLine1) {
        this.adressLine1 = adressLine1;
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