package dev.paie.service;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Cotisation;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.Periode;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.Utilisateur;
import dev.paie.entite.Utilisateur.ROLES;

@Service
public class InitialiserDonneesServiceDev implements InitialiserDonneesService {

	@Autowired
	ApplicationContext context;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void initialiser() {

		context.getBeansOfType(Grade.class).forEach((code, bean) -> em.merge(bean));
		context.getBeansOfType(Cotisation.class).forEach((code, bean) -> em.persist(bean));
		context.getBeansOfType(Entreprise.class).forEach((code, bean) -> em.persist(bean));
		context.getBeansOfType(ProfilRemuneration.class).forEach((code, bean) -> em.persist(bean));

		for (int i = 1; i < 13; i++) {
			LocalDate localdate = LocalDate.of(LocalDate.now().getYear(), i, 1);
			em.persist(new Periode(localdate, localdate.with(TemporalAdjusters.lastDayOfMonth())));
		}

		Utilisateur user = new Utilisateur("ben", passwordEncoder.encode("cookies"), true,
				ROLES.valueOf("ROLE_ADMINISTRATEUR"));
		em.persist(user);

		Utilisateur user1 = new Utilisateur("warsama", passwordEncoder.encode("voisin"), true,
				ROLES.valueOf("ROLE_UTILISATEUR"));
		em.persist(user1);
	}

}
