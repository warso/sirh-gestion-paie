package dev.paie.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.ProfilRemunerationRepository;
import dev.paie.repository.RemunerationEmployeRepository;
import dev.paie.service.CotisationServiceJpa;
import dev.paie.service.RemunerationEmployeJpaService;

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
	RemunerationEmployeJpaService remunEmpService;

	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerEmploye() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/creerEmploye");
		mv.addObject("profil", profilRep.findAll());
		mv.addObject("grade", gradeRep.findAll());
		mv.addObject("entreprise", entreRep.findAll());
		return mv;

	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(@ModelAttribute("employe") RemunerationEmploye nouveauEmploye) {
		
		remunEmpService.creer(nouveauEmploye);
		return "employeSuccess";

	}

}
