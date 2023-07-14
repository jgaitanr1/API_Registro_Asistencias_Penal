package com.csjll.api.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csjll.api.DAO.TallerDAO;
import com.csjll.api.Entity.Taller;

@Service
public class TallerServiceImpl implements TallerService{

	@Autowired
	private TallerDAO tallerDAO;
	
	@Override
	public Taller save(Taller taller) {
		return tallerDAO.save(taller);
	}

	@Override
	public Taller update(Taller taller) {
		return tallerDAO.save(taller);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Taller> findAll() {
		return tallerDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Taller> findById(Long id) {
		return tallerDAO.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Taller> findByGrupo(String grupo) {
		return tallerDAO.findByGrupo(grupo);
	}
	

	@Override
	public void deleteById(Long Id) {
		tallerDAO.deleteById(Id);
	}

}
