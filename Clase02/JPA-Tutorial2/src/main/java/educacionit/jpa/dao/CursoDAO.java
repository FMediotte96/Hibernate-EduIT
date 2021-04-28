package educacionit.jpa.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import educacionit.jpa.entidades.Curso;
@Repository
public interface CursoDAO extends CrudRepository<Curso, Integer>{


}
