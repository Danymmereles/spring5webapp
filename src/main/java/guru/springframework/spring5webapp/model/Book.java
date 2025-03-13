package guru.springframework.spring5webapp.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Book {

    @Id //Como va a ser una entidad necesitamos una pk
    @GeneratedValue (strategy = GenerationType.AUTO) //La forma de generar la pk
    private  Long id;
    private String title;
    private String isbn;

    @ManyToMany
    @JoinTable(name = "author_book",
               joinColumns = @JoinColumn(name = "book_id"),
               inverseJoinColumns = @JoinColumn(name = "author_id"))//Creamos una join table
    private Set<Author> authors;
    //Relacion many a many

    //Constructors
    public Book() {}
    public Book(String title, String isbn, Set<Author> authors) {
        this.title = title;
        this.isbn = isbn;
        this.authors = authors;
    }

    //Getters
    public String getTitle() {
        return title;
    }
    public String getIsbn() {
        return isbn;
    }
    public Set<Author> getAuthors() {
        return authors;
    }
    public Long getId() {
        return id;
    }

    //Setters
    public void setTitle(String title) {
        this.title = title;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public void setAuthor(Set<Author> authors) {
        this.authors = authors;
    }
    public void setId(Long id) {
        this.id = id;
    }

    //Equals and hashcode
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }
    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    //ToString
    /*
        Nos mostrara las propiedades de los books
     */
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", authors=" + authors +
                '}';
    }
}
