package dev.paie.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.ServicesConfig;

//Sélection des classes de configuration Spring à utiliser lors du test

@ContextConfiguration(classes = { ServicesConfig.class })

// Configuration JUnit pour que Spring prenne la main sur le cycle de vie du
// test

@RunWith(SpringRunner.class)

public class InitialiserDonneesServiceDevTest {

	@Autowired
	ApplicationContext context;
	@Autowired
	InitialiserDonneesServiceDev initDonneesService;

	@Test
	public void initialiser() {

	}

}
