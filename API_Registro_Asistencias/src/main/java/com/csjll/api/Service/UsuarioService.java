package com.csjll.api.Service;

import java.util.Optional;

import com.csjll.api.Entity.Usuario;

public interface UsuarioService {

	public Usuario save(Usuario usuario);

	public Usuario update(Usuario usuario);

	public Iterable<Usuario> findAll();

	public Optional<Usuario> findById(Long id);

	public Usuario obtenerUsuario(String nroDocumento);

	public void deleteById(Long Id);
}
