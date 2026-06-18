package com.tallerbicicletas.tallerbicicletasbackend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {
    private Long idUsuario;
    private String nombre;
    private String apellido;
    private String email;
    private String rol;
    private Boolean activo;
}