package educacionit.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import educacionit.jpa.entidades.herencia1.Persona1DAO;
import educacionit.jpa.entidades.herencia4.Cliente4;
import educacionit.jpa.entidades.herencia4.Cliente4DAO;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner{

	  @Autowired
	  Persona1DAO dao;
	  
	  @Autowired
	  Cliente4DAO cliente4Dao;
	  
	  public static void main(String[] args) {
	    SpringApplication.run(JpaApplication.class, args);
	  }
	  @Override
	  public void run(String... args) throws Exception {
		  
//		  Cliente1 p = new Cliente1();
//		  p.setApellido("Perez2");
//		  p.setNombre("Max2i");
//		  p.setCantidadDeCompras(2);
//		  p.setNumeroCliente(232433L);
//		  dao.save(p);
//		  
		  
//		  Cliente2 c2 = new Cliente2();
//		  c2.setApellido("Perez2");
//		  c2.setNombre("Max2i");
//		  c2.setCantidadDeCompras(2);
//		  c2.setNumeroCliente(232433L);
//		  
//		  cliente2Dao.save(c2);
		  
//		  Cliente3 c3 = new Cliente3();
//		  c3.setApellido("Perez2");
//		  c3.setNombre("Max2i");
//		  c3.setCantidadDeCompras(2);
//		  c3.setNumeroCliente(232433L);
//		  
//		  cliente3Dao.save(c3);
		  
		  Cliente4 c4 = new Cliente4();
		  c4.setApellido("Perez2");
		  c4.setNombre("Max2i");
		  c4.setCantidadDeCompras(2);
		  c4.setNumeroCliente(232433L);
		  
		  cliente4Dao.save(c4);
		
	  }


}
