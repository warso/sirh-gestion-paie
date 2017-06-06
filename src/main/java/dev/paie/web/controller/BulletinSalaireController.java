package dev.paie.web.controller;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.BulletinSalaire;
import dev.paie.repository.BulletinRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.RemunerationEmployeRepository;
import dev.paie.service.CalculerRemunerationServiceSimple;

@Controller
@RequestMapping("/bulletins")
public class BulletinSalaireController {

	@Autowired
	PeriodeRepository periodeRep;
	@Autowired
	RemunerationEmployeRepository remunEmpRep;
	@Autowired
	BulletinRepository bulletinRep;
	@Autowired
	CalculerRemunerationServiceSimple calculer;

	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerBulletin() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/creerBulletin");
		mv.addObject("periode", periodeRep.findAll());
		mv.addObject("remun", remunEmpRep.findAll());
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	public ModelAndView listerEmploye() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/listerBulletin");
		mv.addObject("bulletins", bulletinRep.findAll());
		return mv;

	}

	@RequestMapping(value = "/creer", method = RequestMethod.POST)
	public String form(@RequestParam("periode") Integer periode,
			@RequestParam("matricule") Integer matricule, @RequestParam("prime") BigDecimal prime,  Model model) {

		BulletinSalaire bulletin = new BulletinSalaire();
		bulletin.setPeriode(periodeRep.findOne(periode));
		bulletin.setRemunerationEmploye(remunEmpRep.findOne(matricule));
		bulletin.setPrimeExceptionnelle(prime);
		bulletin.setDateHeure(ZonedDateTime.now());
		bulletinRep.saveAndFlush(bulletin);

		return "redirect:/mvc/bulletins/lister";
	}

}
