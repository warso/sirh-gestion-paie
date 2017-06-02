package dev.paie.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import dev.paie.service.InitialiserDonneesService;


@Configuration
@EnableWebMvc
@ComponentScan("dev.paie.web.controller")
@ImportResource({"classpath:cotisations-non-imposables.xml","classpath:cotisations-imposables.xml","classpath:entreprises.xml", "classpath:grades.xml", "classpath:profils-remuneration.xml"} )
@Import(ServicesConfig.class)


public class WebAppConfig {
	
	@Autowired
	private InitialiserDonneesService initDonneeService;

	@Bean
	public ViewResolver viewResolver() {

		return new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
	}
	
	@PostConstruct
	public void onInit(){
		initDonneeService.initialiser();
	}

}