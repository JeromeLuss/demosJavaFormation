package fr.jeje.demos.java;

import java.util.Arrays;

public class DemoChaine {
	/*
	 * Version partant des exemples ENI mais personnalisés et augmentés
	 */

	public static void main(String[] args) {
		String ch1 = "une chaîne";
		String ch2 = new String("une autre chaîne");
		
		char[] ch3 = new char[5];
		char[] ch4 = {'m','a','r','d','i'};
		
		System.out.println("valeur de ch1 = " + ch1);
		
		System.out.println(Arrays.toString(ch4));
		
		String ch6 = Arrays.toString(ch4);
		
		System.out.println(ch4);
		
		String ch5 = new String(ch4);
		
		System.out.println(ch5);
		
		String ch7 = "azerty";
		String ch8 = "AZERTY";
		
		System.out.println("comparaison sans casse de : " + ch7 + " et " + ch8 + " = " + ch7.equalsIgnoreCase(ch8));
		
		System.out.println(ch6.toUpperCase());
		
	}

}
