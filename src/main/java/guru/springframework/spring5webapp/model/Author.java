package guru.springframework.spring5webapp.model;

import javax.persistence.*;
import java.util.Set;

/*
    Con el JPA vamos a recuperar y mandar cosas de la base de datos por lo
    que necesitamos:
        1) que sea una entidad
        2) que tenga un valor de identificacion o sea id
    Considerar que se hace esto para persistirlo con Hibernate
 */
@Entity
public class Author {

    @Id //Como va a ser una entidad necesitamos una pk
    @GeneratedValue (strategy = GenerationType.AUTO) //La forma de generar la pk
    private  Long id;
    private String firstName;
    private String lastName;

    @ManyToMany(mappedBy = "authors")//Campo se liga por authors
    private Set<Book> books;
    //Relacion many a many

    //Constructores
    public Author() {}
    public Author(String firstName, String lastName, Set<Book> books) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.books = books;
    }

    //Getters
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public Set<Book> getBooks() {
        return books;
    }
    public Long getId() {
        return id;
    }

    //Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setBooks(Set<Book> books) {
        this.books = books;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
