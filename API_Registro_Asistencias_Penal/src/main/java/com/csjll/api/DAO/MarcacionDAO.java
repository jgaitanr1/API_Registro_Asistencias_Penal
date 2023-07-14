package com.csjll.api.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csjll.api.Entity.Marcacion;
import com.csjll.api.Entity.Usuario;

public interface MarcacionDAO extends JpaRepository<Marcacion, Long>{
	
	public Iterable<Marcacion> findByusuario(Usuario idUsuario);

}
