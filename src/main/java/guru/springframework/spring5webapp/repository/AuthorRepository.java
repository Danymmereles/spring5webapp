package guru.springframework.spring5webapp.repository;

import guru.springframework.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

/*
    Los repositorios son los encargados de la persistencia y consulta de los
    datos
    Es un patron de diseño
    Ayuda a enfocarnos en las funcionalidades del negocio
 */

public interface AuthorRepository extends CrudRepository<Author, Long> {
    //CrudRepository<Type of data, id value>
    //Spring Data JPA se encarga de la implementacion
}
