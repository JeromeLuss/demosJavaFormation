package fr.jeje.demos.java;

import fr.jeje.exemples.classes.*; //pour utiliser les classes ce ce package

public class Dem_Programme {

	public static void main(String[] args) {
		//on pourra tester différentes classes avec ce programme
		
		Personne p = new Personne("Jéjé", "LaMalice");
		//p est la variable qui référence l'objet, comme un pointeur
		System.out.println(p.declinerID());

	}

}
