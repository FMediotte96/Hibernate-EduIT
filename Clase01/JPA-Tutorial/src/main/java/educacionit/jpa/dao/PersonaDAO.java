package educacionit.jpa.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import educacionit.jpa.entidades.Persona;

@Repository
public interface PersonaDAO extends CrudRepository<Persona, Integer> {

}
