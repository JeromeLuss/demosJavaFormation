package fr.jeje.exemples.classes;

public class Vehicule {
	private int vitesse;
	private int vitesseMaximum;
	
	// Constructeur
	/*
	 * si je définit un constructeur ayant des paramètres, je ne pourrais plus utiliser le 
	 * constructeur par défaut qui ne faisait rien. je dois le réécrire si je veux pouvoire
	 * l'utiliser. Ci dessous.
	*/
	public Vehicule() {}
	
	public Vehicule(int v, int vm) {
		if(v<=vm && v>0) {
			vitesse = v;
			vitesseMaximum = vm;
		}
	}
	
	public void accelerer() {
		if(vitesse < vitesseMaximum) {
			vitesse++;
		}
	}
	
	public void freiner() {
		if(vitesse >0) {
			vitesse--;
		}
	}
	

}
