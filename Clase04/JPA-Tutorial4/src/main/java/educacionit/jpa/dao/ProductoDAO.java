package educacionit.jpa.dao;

import educacionit.jpa.entidades.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoDAO extends CrudRepository<Producto, Integer> {

}
