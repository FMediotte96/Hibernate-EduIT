package educacionit.jpa;

import educacionit.jpa.dao.PersonaDAO;
import educacionit.jpa.dao.PersonaDAOImpl;
import educacionit.jpa.dao.ProductoDAO;
import educacionit.jpa.dto.PersonaDTO;
import educacionit.jpa.entidades.Persona;
import educacionit.jpa.entidades.Producto;
import educacionit.jpa.entidades.Telefono;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {

    @Autowired
    PersonaDAO dao;

    @Autowired
    ProductoDAO productoDao;

    @Autowired
    PersonaDAOImpl daoImpl;

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        List<Persona> pByApellido = daoImpl.findByApellido("Perez");
        List<Persona> mayoresDeEdad = daoImpl.findMayorDeEdad();
        Long cantPersonas = daoImpl.cuantasPersonasHay();
        List<Persona> pByPhone = dao.findByPhone(1530);

        List<Persona> personas = dao.findAll();
        for (Persona persona : personas) {
            System.out.println(persona);
        }

        Persona p = new Persona();
        p.setApellido("Lopez");
        p.setNombre("Juan");
        p.setEdad(57);

        Telefono t = new Telefono();
        t.setNumero(111);
        t.setTipo("Celu");
        p.addTelefono(t);
        dao.save(p);

        Persona p1 = dao.findById(1).get();
        System.out.println(p.getApellido());

        List<String> apellidos = daoImpl.getAllApellidosMayuscula();
        for (Object object : apellidos) {
            System.out.println(object);
        }

        List<PersonaDTO> lista = daoImpl.getPersonaDTO();
        for (PersonaDTO personaDTO : lista) {
            System.out.println(personaDTO.getNombre() + ", " + personaDTO.getNumero());
        }

        List<Persona> pByEdad = daoImpl.findByEdad(17);
        for (Persona persona : personas) {
            System.out.println(persona.getApellido());
        }

        Producto producto = new Producto();
        producto.setDescripcion("Algo");
        producto.setFechaAlta(new Date());
        producto.setPrecio(20.4);

        productoDao.save(producto);

        productoDao.findAll().forEach(System.out::println);
    }

}
