package guru.springframework.spring5webapp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
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
    private Set<Book> books = new HashSet<>();
    //Relacion many a many
    /*
        Como no esta mas el constructor para facilitar la creacion, hay que
        inicializarlo antes
     */

    //Constructores
    public Author() {}
    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        // this.books = books; mas facil de crear
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

    //Equals and hashcode
    /*
        Solo usaremos el id porque es la forma de identificar a un autor
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id);
    }
    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    //ToString
    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", books=" + books +
                '}';
    }
}
