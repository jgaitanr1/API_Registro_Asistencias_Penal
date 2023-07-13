package com.csjll.api.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csjll.api.DAO.MarcacionDAO;
import com.csjll.api.Entity.Marcacion;
import com.csjll.api.Entity.Usuario;

@Service
public class MarcacionServiceImpl implements MarcacionService{

	@Autowired
	private MarcacionDAO marcacionDAO;

	@Override
	public Marcacion save(Marcacion marcacion) {
		return marcacionDAO.save(marcacion);
	}

	@Override
	public Marcacion update(Marcacion marcacion) {
		return marcacionDAO.save(marcacion);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Marcacion> findAll() {
		return marcacionDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Marcacion> findById(Long id) {
		return marcacionDAO.findById(id);
	}

	@Override
	public void deleteById(Long Id) {
		marcacionDAO.deleteById(Id);
	}

	@Override
	public Iterable<Marcacion> findByusuario(Usuario id) {
		return marcacionDAO.findByusuario(id);
	}

}
