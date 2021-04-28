package educacionit.jpa.entidades2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Curso2 {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String nombre;
	private Date fechaInicio;
	private Integer horasDuracion;
	private String diasCursada;

	@OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Comentario2> comentarios = new ArrayList<>();

	public void agregaComentario(Comentario2 commentario) {
		comentarios.add(commentario);
		commentario.setCurso(this);
	}

	public void removeComment(Comentario2 commentario) {
		comentarios.remove(commentario);
		commentario.setCurso(null);
	}

	public Integer getId() {
		return id;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Integer getHorasDuracion() {
		return horasDuracion;
	}

	public void setHorasDuracion(Integer horasDuracion) {
		this.horasDuracion = horasDuracion;
	}

	public String getDiasCursada() {
		return diasCursada;
	}

	public void setDiasCursada(String diasCursada) {
		this.diasCursada = diasCursada;
	}

	public List<Comentario2> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario2> comentarios) {
		this.comentarios = comentarios;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
