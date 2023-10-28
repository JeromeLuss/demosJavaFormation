package fr.jeje.demos.java;

public class DemoConditionnelles {
	/*
	 * Version partant des exemples ENI mais personnalisés et augmentés
	 */
	public static void main(String[] args) {
		int uneValeur = 441;
		
		if(uneValeur == 444) {
			System.out.println("la variable = 444");
		}else if(uneValeur == 222){
			System.out.println("la variable = 222");
		}else {
			System.out.println("la variable != 444 ni 222");
		}
	
		
		switch (uneValeur) {
		case 444: 
			System.out.println("case 444");
			break;
		case 222: 
			System.out.println("case 222");
			break;

		default:
			System.out.println("case ni 444 ni 222");
		}
	}
}
