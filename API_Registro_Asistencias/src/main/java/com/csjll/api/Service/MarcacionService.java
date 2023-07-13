package com.csjll.api.Service;

import java.util.Optional;

import com.csjll.api.Entity.Marcacion;
import com.csjll.api.Entity.Usuario;

public interface MarcacionService {

	public Marcacion save(Marcacion marcacion);
	
	public Marcacion update(Marcacion marcacion);
	
	public Iterable<Marcacion> findAll();
	
	public Optional<Marcacion> findById(Long id);
	
	public Iterable<Marcacion> findByusuario(Usuario id);
	
	public void deleteById(Long Id);
}
