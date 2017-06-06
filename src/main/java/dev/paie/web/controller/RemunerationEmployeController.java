package dev.paie.web.controller;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.ProfilRemunerationRepository;
import dev.paie.repository.RemunerationEmployeRepository;

@Controller
@RequestMapping("/employes")
public class RemunerationEmployeController {

	@Autowired
	ProfilRemunerationRepository profilRep;
	@Autowired
	GradeRepository gradeRep;
	@Autowired
	EntrepriseRepository entreRep;
	@Autowired
	RemunerationEmployeRepository remunEmpRep;
	

	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	@Secured("ROLE_ADMINISTRATEUR")
	public ModelAndView creerEmploye() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/creerEmploye");
		mv.addObject("profil", profilRep.findAll());
		mv.addObject("grade", gradeRep.findAll());
		mv.addObject("entreprise", entreRep.findAll());
		return mv;

	}

	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	@Secured({"ROLE_ADMINISTRATEUR","ROLE_ADMINISTRATEUR"})
	public ModelAndView listerEmploye() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/listerEmploye");
		mv.addObject("employes",remunEmpRep.findAll());
		return mv;

	}

	@RequestMapping(value = "/creer", method = RequestMethod.POST)
	public String form(@RequestParam("matricule") String matricule, @RequestParam("entreprise") Integer entreprise,
			@RequestParam("profil") Integer profil, @RequestParam("grade") Integer grade, Model model) {

		RemunerationEmploye remnum = new RemunerationEmploye();
		remnum.setMatricule(matricule);
		remnum.setDateHeure(ZonedDateTime.now());
		remnum.setEntreprise(entreRep.findOne(entreprise));
		remnum.setProfilRemuneration(profilRep.findOne(profil));
		remnum.setGrade(gradeRep.findOne(grade));
		remunEmpRep.saveAndFlush(remnum);
		return "redirect:/mvc/employes/lister";
	}

}
