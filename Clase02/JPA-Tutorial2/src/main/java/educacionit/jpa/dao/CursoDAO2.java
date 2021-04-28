package educacionit.jpa.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import educacionit.jpa.entidades2.Curso2;
@Repository
public interface CursoDAO2 extends CrudRepository<Curso2, Integer>{


}
