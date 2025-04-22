package com.example.viajesmascotas.controller;

import com.example.viajesmascotas.model.Usuario;
import com.example.viajesmascotas.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    private static final Logger logger = Logger.getLogger(UsuarioController.class.getName());

    // GET: Obtener todos los usuarios
    @GetMapping
    public List<Usuario> getAllUsuarios() {
        logger.info("GET /usuarios - Obteniendo todos los usuarios");
        return usuarioService.getAllUsuarios();
    }

    // GET: Obtener un usuario por ID
    @GetMapping("/{id}")
    public Optional<Usuario> getUsuarioById(@PathVariable int id) {
        logger.info("GET /usuarios/" + id + " - Obteniendo usuario por ID");
        return usuarioService.getUsuarioById(id);
    }

    // POST: Crear un nuevo usuario
    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        logger.info("POST /usuarios - Creando nuevo usuario");
        return usuarioService.createUsuario(usuario);
    }

    // PUT: Actualizar un usuario existente
    @PutMapping("/{id}")
    public Usuario updateUsuario(@PathVariable int id, @RequestBody Usuario usuario) {
        logger.info("PUT /usuarios/" + id + " - Actualizando usuario");
        Usuario actualizado = usuarioService.updateUsuario(id, usuario);
        if (actualizado == null) {
            logger.warning("No se pudo actualizar. Usuario con ID " + id + " no encontrado.");
        }
        return actualizado;
    }

    // DELETE: Eliminar un usuario por ID
    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable int id) {
        logger.info("DELETE /usuarios/" + id + " - Eliminando usuario");
        usuarioService.deleteUsuario(id);
    }
}
