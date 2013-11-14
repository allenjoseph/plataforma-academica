package com.platacad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.platacad.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

}
