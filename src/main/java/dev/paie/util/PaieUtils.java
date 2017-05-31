package dev.paie.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import org.springframework.stereotype.Component;

@Component
public class PaieUtils {
	/**
	 * 
	 * Formate un nombre sous la forme xx.xx (exemple : 2.00, 1.90). L'arrondi
	 * 
	 * se faire en mode "UP" => 1.904 devient 1.91
	 *
	 * @param decimal
	 *            nombre à formater
	 * 
	 * @return le nombre formaté
	 * 
	 */

	public String formaterBigDecimal(BigDecimal decimal) {

		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		df.setRoundingMode(RoundingMode.UP);
		df.setMinimumFractionDigits(2);
		df.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.UK));
		df.setGroupingUsed(false);
		return df.format(decimal);

	}

}
