package fr.jeje.exemples.classes;
//les packages permettent de gérer les nombreux nécessaires à une appli. 
// import fr.jeje.exemples.classes.*;

//pour accéder aux classes d'un autre package, une classe doit importer le package de la classe nécessaire. 

/*
 * classe crée dans le cadre du suivi du cours complet vidéo de ENI
 */
public class Personne {
	//Commence par une majuscule. puis camelCase (UpperCamelCase). Nom classe ) nom fichier contenant la classe.
	/*
	 * une classe peut avoir des caractéristiques (public etc)
	 * Public permet d'être accédé par tout membre de l'appli
	 * des attributs (prénom, nom ..)
	 * et des comportements (méthodes = fonctions ou procédures en contexte objet)
	 * 
	 * Les attributs et méthodes sont appelés les "mambres" de cette classe
	 * 
	 * en UML
	 *   ____________________________________
	 *   |                                  | 
	 *   |          Personne				|
	 *   |__________________________________|
	 *   |									|
	 *   |  nom : String					|
	 *   |  prenom : String					|
	 *   |__________________________________|
	 *   |									|
	 *   |  parler(phrase : String)			|
	 *   |__________________________________|
	 *   
	 *   mot clef "this" = l'instance courante
	 *   
	 *   La notion de surcharge, en changeant les paramètres (en nombre de paramètres) ou en type, permet d'avoir
	 *   des actions différentes dans une fonction de même nom. 
	 *   
	 *   
	 */
	
	//Variables d'instance. Durée de vie = durée de vie de l'instance. 
	private String nom;
	
	private String prenom;
	
	

	// constantes pour des fonctions comme declinerID surchargée
	final int PRENOM = 0;
	final int NOM = 1;
	
	//************ CONSTRUCTOR ***************
	//NB Tout objet sans constructeur possède un constructeur implicite qui mets des valeurs nulles ou par défaut.
	//il vaut mieux "surcharger" ce constructeur pour définir les valeurs par défaut.
	
	public Personne() { //surcharge
		this("Anonyme","Anonyme"); //rappel du constructeur avec 2 Strings
	}
	
	public Personne(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}
	//************ FIN CONSTRUCTOR ***************

	
	//=============Méthodes==============
	//----------------setters-------------
	void setNom(String nom) { 
		this.nom = nom;
	}
	
	
	void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	//---------------getters--------------
	public String getPrenom() {
		return prenom;
	}


	public String getNom() {
		return nom;
	}
	
	public String declinerID() {//méthode de base
		return getNom()+ " " + getPrenom();
	}
	
	public String declinerID(int type) {//surcharge
		String identite;
		switch (type) {
		case NOM:
			identite = getNom();
			break;
		case PRENOM:
			identite = getPrenom();
			break;

		default:
			identite = declinerID(); //on peut réutiliser une méthode de base sa version surchargée.  
		}
		return identite;
	}
}
