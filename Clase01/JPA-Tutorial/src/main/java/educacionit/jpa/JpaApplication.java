package educacionit.jpa;

import educacionit.jpa.dao.ProductoDAO;
import educacionit.jpa.entidades.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import educacionit.jpa.dao.PersonaDAO;
import educacionit.jpa.entidades.Persona;

import java.util.Date;

@SpringBootApplication
//@EntityScan( basePackages = {"educacionit.jpa"} )
public class JpaApplication implements CommandLineRunner {

    PersonaDAO personaDAO;
    ProductoDAO productoDAO;

    @Autowired
    public JpaApplication(PersonaDAO personaDAO, ProductoDAO productoDAO) {
        this.personaDAO = personaDAO;
        this.productoDAO = productoDAO;
    }

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Persona persona = new Persona();
        persona.setNombre("Facu");
        persona.setApellido("Mediotte");
        persona.setEdad(25);

        //El save funciona como un saveOrUpdate
        personaDAO.save(persona);

        personaDAO.findAll().forEach((p) -> System.out.println(p.getNombre()));

        //Producto Lab01
        Producto p = new Producto();
        p.setDescripcion("PS4");
        p.setPrecio(80000.0);
        p.setFechaAlta(new Date());

        productoDAO.save(p);

        productoDAO.findAll().forEach(System.out::println);
    }

}
