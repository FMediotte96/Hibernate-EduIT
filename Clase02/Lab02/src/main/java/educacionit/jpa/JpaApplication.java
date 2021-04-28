package educacionit.jpa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import educacionit.jpa.entidades.Domicilio;
import educacionit.jpa.entidades.Telefono;
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

    @Autowired
    PersonaDAO pDao;

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

        Persona p = new Persona();
        p.setApellido("Mediotte");
        p.setNombre("Facundo");
        p.setEdad(25);

        Telefono t = new Telefono();
        t.setNumero(1530);
        t.setTipo("Celular");

        p.addTelefono(t);

        Domicilio d = new Domicilio();
        d.setCalle("Calle");
        d.setNumero(123);

        p.setDomicilios(Collections.singletonList(d));

        pDao.save(p);

    }

}
