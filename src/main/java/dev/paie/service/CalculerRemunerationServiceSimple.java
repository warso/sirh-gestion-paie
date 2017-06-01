package dev.paie.service;

import java.math.BigDecimal;


import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import dev.paie.entite.BulletinSalaire;

import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.util.PaieUtils;

@Service
public class CalculerRemunerationServiceSimple implements CalculerRemunerationService {

	@Autowired
	private PaieUtils paieUtils;

	@Override
	public ResultatCalculRemuneration calculer(BulletinSalaire bulletin) {

		ResultatCalculRemuneration calcul = new ResultatCalculRemuneration();
		
		BigDecimal salairebase = bulletin.getRemunerationEmploye().getGrade().getNbHeuresBase()
				.multiply(bulletin.getRemunerationEmploye().getGrade().getTauxBase());
		
		BigDecimal salaireBrut = salairebase.add(bulletin.getPrimeExceptionnelle());
		
		BigDecimal totalRetenueSalarial = bulletin.getRemunerationEmploye().getProfilRemuneration()
				.getCotisationsNonImposables().stream().filter(c -> c.getTauxSalarial() != null)
				.map(c -> c.getTauxSalarial().multiply(salaireBrut))
				.collect(Collectors.reducing((v1, v2) -> v1.add(v2))).get();

		BigDecimal totalCotisationsPatronales = bulletin.getRemunerationEmploye().getProfilRemuneration()
				.getCotisationsNonImposables().stream().filter(c -> c.getTauxPatronal() != null)
				.map(c -> c.getTauxPatronal().multiply(salaireBrut))
				.collect(Collectors.reducing((v1, v2) -> v1.add(v2))).get();
		
		BigDecimal netImposable = salaireBrut.subtract(totalRetenueSalarial);
		
		BigDecimal netAPayer = netImposable.subtract(

				bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsImposables().stream()
						.filter(c -> c.getTauxSalarial() != null).map(c -> c.getTauxSalarial().multiply(salaireBrut))
						.collect(Collectors.reducing((v1, v2) -> v1.add(v2))).get());

		calcul.setSalaireDeBase(paieUtils.formaterBigDecimal(salairebase));
		calcul.setSalaireBrut(paieUtils.formaterBigDecimal(salaireBrut));
		calcul.setTotalRetenueSalarial(paieUtils.formaterBigDecimal(totalRetenueSalarial));
		calcul.setTotalCotisationsPatronales(paieUtils.formaterBigDecimal(totalCotisationsPatronales));
		calcul.setNetImposable(paieUtils.formaterBigDecimal(netImposable));
		calcul.setNetAPayer(paieUtils.formaterBigDecimal(netAPayer));

		return calcul;
	}

}
