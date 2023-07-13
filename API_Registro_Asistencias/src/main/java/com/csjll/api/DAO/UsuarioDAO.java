package com.csjll.api.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csjll.api.Entity.Usuario;

public interface UsuarioDAO extends JpaRepository<Usuario, Long>{
	
	public Usuario findBynroDocumento(String nroDocumento);
}
