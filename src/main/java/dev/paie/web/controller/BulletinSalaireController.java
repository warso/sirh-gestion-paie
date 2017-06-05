package dev.paie.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.RemunerationEmployeRepository;


@Controller
@RequestMapping("/bulletins")
public class BulletinSalaireController {

	@Autowired
	PeriodeRepository periodeRep;
	@Autowired
	RemunerationEmployeRepository remunEmpRep;

	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerBulletin() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/creerBulletin");
		mv.addObject("periode", periodeRep.findAll());
		mv.addObject("remun", remunEmpRep.findAll());
		return mv;

	}

}
