package dev.paie.repository;


import java.math.BigDecimal;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.ServicesConfig;
import dev.paie.entite.Avantage;


//Sélection des classes de configuration Spring à utiliser lors du test

@ContextConfiguration(classes = { ServicesConfig.class })

// Configuration JUnit pour que Spring prenne la main sur le cycle de vie du
// test

@RunWith(SpringRunner.class)

public class AvantageRepositoryTest {

	@Autowired
	private AvantageRepository avantageRepository;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {

		// sauvegarder un nouvel avantage

		Avantage avantage = new Avantage();
		avantage.setCode("A01");
		avantage.setNom("merite");
		avantage.setMontant(new BigDecimal("180.00"));

		avantageRepository.save(avantage);

		// vérifier qu'il est possible de récupérer le nouvel avantage via
		// la méthode findOne

		avantageRepository.findOne(avantage.getId());

		// modifier un avantage

		Avantage avantageAModif = avantageRepository.findOne(avantage.getId());
		String codeModifie = UUID.randomUUID().toString();
		avantageAModif.setCode(codeModifie);
		avantageRepository.save(avantageAModif);

		// vérifier que les modifications sont bien prises en compte via la
		// méthode findOne

		avantageRepository.findOne(avantage.getId());
		
		// test methode find by code
		avantageRepository.findByCode(avantage.getCode());
	}
	
	

}