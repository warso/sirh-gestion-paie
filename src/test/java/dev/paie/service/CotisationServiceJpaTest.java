package dev.paie.service;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.ServicesConfig;
import dev.paie.entite.Cotisation;


//Sélection des classes de configuration Spring à utiliser lors du test

@ContextConfiguration(classes = { ServicesConfig.class })

// Configuration JUnit pour que Spring prenne la main sur le cycle de vie du
// test

@RunWith(SpringRunner.class)
public class CotisationServiceJpaTest {

	@Autowired
	private CotisationService cotisationService;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {

		// sauvegarder une nouvelle cotisation

		Integer id = new Random().nextInt();
		Cotisation cotisation = new Cotisation();
		cotisation.setId(id);
		cotisation.setCode("EP01");
		cotisation.setLibelle("URSSAF MALADIE - MATERNITE - INVALIDITE");
		cotisation.setTauxSalarial(new BigDecimal("0.007"));
		cotisation.setTauxPatronal(new BigDecimal("0.128"));
		
		cotisationService.sauvegarder(cotisation);
		
		// vérifier qu'il est possible de récupérer la nouvelle cotisation
		// via la méthode lister
		
		List<Cotisation> listeCotisationsApresSauvegarder = cotisationService.lister();
		assertTrue(listeCotisationsApresSauvegarder.stream().anyMatch(g -> g.getId().equals(id)));
		
		// modifier une cotisation
		
		Cotisation cotisationAModif = listeCotisationsApresSauvegarder.get(0);
		String codeModifie =  UUID.randomUUID().toString();
		cotisationAModif.setCode(codeModifie);
		
		cotisationService.mettreAJour(cotisationAModif);

		// vérifier que les modifications sont bien prises en compte via la
		// méthode lister
		
		List<Cotisation> listeCotisationsApresModif = cotisationService.lister();
		assertTrue(listeCotisationsApresModif.stream().filter(g -> g.getCode().equals(codeModifie)).count() > 0);

	}

}
