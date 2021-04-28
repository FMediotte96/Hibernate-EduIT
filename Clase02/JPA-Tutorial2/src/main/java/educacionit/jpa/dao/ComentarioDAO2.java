package educacionit.jpa.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import educacionit.jpa.entidades2.Comentario2;
@Repository
public interface ComentarioDAO2 extends CrudRepository<Comentario2, Integer>{


}
