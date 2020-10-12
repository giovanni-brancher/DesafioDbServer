package br.automationpractice.core;

import java.text.DecimalFormat;

/**
 * Métodos auxiliares.
 * 
 * @author Giovanni D. Brancher
 */
public class Utils {
	
	public static String adicionarMascaraMoedaDolar(Float valor) {
		DecimalFormat df = new DecimalFormat("0.00");
		return "$" + df.format(valor).replace(',', '.');
	}
	
}