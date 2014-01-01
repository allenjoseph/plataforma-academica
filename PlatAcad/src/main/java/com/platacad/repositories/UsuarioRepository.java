package com.platacad.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.platacad.model.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

	@Query("select count(a) from Mensaje a where a.idUsuarioDestinoFk.idUsuarioPk = (:id) and a.estado = (:estado)")
	public Integer getTotalMensajes(@Param("id") String usuario, @Param("estado") Integer estado);
	
	@Query("select count(t) from TrabajoEncargado t, Matricula m where t.idCursoAperturadoFk = m.idCursoAperturadoFk and m.idUsuarioFk = (:id) and t.estado = (:estado)")
	public Integer getTotalTrabajos(@Param("id") String usuario, @Param("estado") Integer estado);
	
	@Query("select count(e) from Examen e, Matricula m where e.idCursoAperturadoFk = m.idCursoAperturadoFk and m.idUsuarioFk = (:id) and e.fechaExamen >= (:fecha)")
	public Integer getTotalExamenes(@Param("id") String usuario, @Param("fecha") Date fecha);
	
	@Query("select u from Usuario u where lower(u.nombres) like ('%' || lower(:text) || '%') or lower(u.apellidoPaterno) like ('%' || lower(:text) || '%') or lower(u.apellidoMaterno) like ('%' || lower(:text) || '%')")
	public List<Usuario> getUsuarios(@Param("text") String text);

}
