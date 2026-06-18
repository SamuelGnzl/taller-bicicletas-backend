package com.tallerbicicletas.tallerbicicletasbackend.service;

import com.tallerbicicletas.tallerbicicletasbackend.dto.UsuarioDTO;
import com.tallerbicicletas.tallerbicicletasbackend.entity.Usuario;
import com.tallerbicicletas.tallerbicicletasbackend.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> obtenerTodos() {
        return usuarioRepository.findAll()
                .stream()
                .map(usuario -> {
                    UsuarioDTO dto = new UsuarioDTO();
                    dto.setIdUsuario(usuario.getIdUsuario());
                    dto.setNombre(usuario.getNombre());
                    dto.setApellido(usuario.getApellido());
                    dto.setEmail(usuario.getEmail());
                    dto.setRol(usuario.getRol());
                    dto.setActivo(usuario.getActivo());
                    return dto;
                })
                .toList();
    }

    // Obtener uno por ID
    public UsuarioDTO obtenerPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + id));

        UsuarioDTO dto = new UsuarioDTO();
        dto.setIdUsuario(usuario.getIdUsuario());
        dto.setNombre(usuario.getNombre());
        dto.setApellido(usuario.getApellido());
        dto.setEmail(usuario.getEmail());
        dto.setRol(usuario.getRol());
        dto.setActivo(usuario.getActivo());
        return dto;
    }

    // Crear usuario
    public UsuarioDTO crear(Usuario usuario) {
        Usuario guardado = usuarioRepository.save(usuario);

        UsuarioDTO dto = new UsuarioDTO();
        dto.setIdUsuario(guardado.getIdUsuario());
        dto.setNombre(guardado.getNombre());
        dto.setApellido(guardado.getApellido());
        dto.setEmail(guardado.getEmail());
        dto.setRol(guardado.getRol());
        dto.setActivo(guardado.getActivo());
        return dto;
    }

    // Editar usuario
    public UsuarioDTO editar(Long id, Usuario datosNuevos) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + id));

        usuario.setNombre(datosNuevos.getNombre());
        usuario.setApellido(datosNuevos.getApellido());
        usuario.setEmail(datosNuevos.getEmail());
        usuario.setRol(datosNuevos.getRol());
        usuario.setActivo(datosNuevos.getActivo());

        Usuario actualizado = usuarioRepository.save(usuario);

        UsuarioDTO dto = new UsuarioDTO();
        dto.setIdUsuario(actualizado.getIdUsuario());
        dto.setNombre(actualizado.getNombre());
        dto.setApellido(actualizado.getApellido());
        dto.setEmail(actualizado.getEmail());
        dto.setRol(actualizado.getRol());
        dto.setActivo(actualizado.getActivo());
        return dto;
    }

    // Eliminar usuario
    public void eliminar(Long id) {
        usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + id));
        usuarioRepository.deleteById(id);
    }
}