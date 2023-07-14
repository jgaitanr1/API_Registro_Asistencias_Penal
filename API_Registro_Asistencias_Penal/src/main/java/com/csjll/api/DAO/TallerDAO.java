package com.csjll.api.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csjll.api.Entity.Taller;

public interface TallerDAO extends JpaRepository<Taller, Long>{

	public Iterable<Taller> findByGrupo(String grupo);

}
