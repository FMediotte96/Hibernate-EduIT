package educacionit.jpa.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import educacionit.jpa.entidades.Comentario;
@Repository
public interface ComentarioDAO extends CrudRepository<Comentario, Integer>{


}
