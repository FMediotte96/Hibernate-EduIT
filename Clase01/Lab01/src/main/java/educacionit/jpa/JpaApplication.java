package educacionit.jpa;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import educacionit.jpa.dao.PersonaDAO;
import educacionit.jpa.dao.ProductoDAO;
import educacionit.jpa.entidades.Persona;
import educacionit.jpa.entidades.Producto;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {

    @Autowired
    ProductoDAO dao;

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Producto producto = new Producto();
        producto.setDescripcion("Algo");
        producto.setFechaAlta(new Date());
        producto.setPrecio(20.4);

        dao.save(producto);

        dao.findAll().forEach((p) -> System.out.println(p.getDescripcion()));
    }


}
