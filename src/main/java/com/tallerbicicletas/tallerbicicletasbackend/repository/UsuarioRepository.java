package com.tallerbicicletas.tallerbicicletasbackend.repository;

import com.tallerbicicletas.tallerbicicletasbackend.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

}
