package educacionit.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import educacionit.jpa.dao.PersonaDAO;
import educacionit.jpa.entidades.Persona;

@SpringBootApplication
//@EntityScan( basePackages = {"educacionit.jpa"} )
public class JpaApplication implements CommandLineRunner {

    @Autowired
    PersonaDAO personaDAO;

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Persona persona = new Persona();
        persona.setApellido("Perez");
        persona.setEdad(60);
        persona.setNombre("Juan");
        personaDAO.save(persona);

        personaDAO.findAll().forEach((p) -> System.out.println(p.getApellido()));
    }


}
