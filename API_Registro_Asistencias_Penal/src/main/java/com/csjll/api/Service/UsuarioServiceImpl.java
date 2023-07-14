package com.csjll.api.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csjll.api.DAO.UsuarioDAO;
import com.csjll.api.Entity.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Override
	public Usuario save(Usuario usuario) {
		return usuarioDAO.save(usuario);
	}

	@Override
	public Usuario update(Usuario usuario) {
		return usuarioDAO.save(usuario);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Usuario> findAll() {
		return usuarioDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Usuario> findById(Long id) {
		return usuarioDAO.findById(id);
	}

	@Override
	public Usuario obtenerUsuario(String nroDocumento) {
		return usuarioDAO.findBynroDocumento(nroDocumento);
	}

	@Override
	public void deleteById(Long Id) {
		usuarioDAO.deleteById(Id);
	}

	
}
