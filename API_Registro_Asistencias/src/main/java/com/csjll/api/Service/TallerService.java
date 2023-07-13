package com.csjll.api.Service;

import java.util.Optional;

import com.csjll.api.Entity.Taller;

public interface TallerService{

	public Taller save(Taller taller);
	
	public Taller update(Taller taller);
	
	public Iterable<Taller> findAll();

	public Optional<Taller> findById(Long id);

	public Iterable<Taller> findByGrupo(String grupo);

	public void deleteById(Long Id);
}
