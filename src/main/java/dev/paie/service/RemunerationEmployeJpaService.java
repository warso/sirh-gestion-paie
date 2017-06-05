package dev.paie.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.RemunerationEmploye;

@Service
public class RemunerationEmployeJpaService implements RemunerationEmployeService {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void creer(RemunerationEmploye nouveauEmploye) {
		em.persist(nouveauEmploye);	
	}

}
