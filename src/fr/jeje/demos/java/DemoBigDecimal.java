package fr.jeje.demos.java;

import java.math.BigDecimal;

public class DemoBigDecimal {
	/**
	 * Montrer les problèmes des virgules flottantes
	 */
	public static void main(String[] args) {
		double test01 = 0.012;
		double sommeFoireuse = test01+test01+test01;
		
		//marche avec 0.1 additionné 10 fois
		double test02 = 0.1;
		double sommeFoireuse02 = 0;
		for (int i = 0; i < 10; i++) {
            sommeFoireuse02 += test02;
        }
		
		System.out.println("somme de 3 flottants de 0.012 = " + sommeFoireuse + " 10x0.1 = " + sommeFoireuse02);
		
		//________ Résolution ________________________
		
		String strTest01 = Double.toString(test01);
		BigDecimal bigDTest01 = new BigDecimal(strTest01);
		BigDecimal bigSomme = bigDTest01.add(bigDTest01).add(bigDTest01);
		
		String strTest02 = Double.toString(test02);
		BigDecimal bigDTest02 = new BigDecimal(strTest02);
		
		BigDecimal bigSomme02 = new BigDecimal(Double.toString(0.0));
		for (int i = 0; i < 10; i++) {
			bigSomme02 = bigSomme02.add(bigDTest02);
        }
		
		
		System.out.println("BigDecimal add de 0.012 = " + bigSomme + " et 10x0.1 = " + bigSomme02);
	}

}
