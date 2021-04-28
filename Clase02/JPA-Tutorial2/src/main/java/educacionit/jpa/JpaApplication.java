package educacionit.jpa;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import educacionit.jpa.entidades.Comentario;
import educacionit.jpa.entidades.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import educacionit.jpa.dao.ComentarioDAO;
import educacionit.jpa.dao.CursoDAO;
import educacionit.jpa.dao.CursoDAO2;
import educacionit.jpa.entidades2.Comentario2;
import educacionit.jpa.entidades2.Curso2;

@SpringBootApplication
//@EntityScan( basePackages = {"educacionit.jpa"} )
public class JpaApplication implements CommandLineRunner {

    @Autowired
    CursoDAO cursoDAO;

    @Autowired
    CursoDAO2 cursoDAO2;

    @Autowired
    ComentarioDAO comentariooDAO;

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//		  Curso curso = new Curso();
//		  curso.setNombre("Introduccion a JPA");
//
//		  DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//		  Date fecha = format.parse("26/10/2019");
//		  curso.setFechaInicio(fecha);
//
//		  curso.setDiasCursada("Lunes de 19 a 22");
//		  curso.setHorasDuracion(21);
//
//		  Comentario comentario = new Comentario();
//		  comentario.setComentario("Excelente curso!!");
//		  comentario.setUsuario("juancito34");
//
//		  Comentario comentario2 = new Comentario();
//		  comentario2.setComentario("Muy buen profe");
//		  comentario2.setUsuario("maxi_up");
//
//		  Comentario comentario3 = new Comentario();
//		  comentario3.setComentario("Gracias totales");
//		  comentario3.setUsuario("pedrito43");
//
//		  List<Comentario> array = curso.getComentarios();
//		  array.add(comentario);
//		  array.add(comentario2);
//		  array.add(comentario3);
//
//		  curso.setComentarios(array);
//		  cursoDAO.save(curso);


        // Parte 2

        Curso2 curso = new Curso2();
        curso.setNombre("Introduccion a JPA");

        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = format.parse("26/10/2019");
        curso.setFechaInicio(fecha);

        curso.setDiasCursada("Lunes de 19 a 22");
        curso.setHorasDuracion(21);

        Comentario2 comentario = new Comentario2();
        comentario.setComentario("Excelente curso!!");
        comentario.setUsuario("juancito34");

        Comentario2 comentario2 = new Comentario2();
        comentario2.setComentario("Muy buen profe");
        comentario2.setUsuario("maxi_up");

        Comentario2 comentario3 = new Comentario2();
        comentario3.setComentario("Gracias totales");
        comentario3.setUsuario("pedrito43");

        List<Comentario2> array = curso.getComentarios();
        array.add(comentario);
        array.add(comentario2);
        array.add(comentario3);

        curso.setComentarios(array);
        cursoDAO2.save(curso);


    }


}
