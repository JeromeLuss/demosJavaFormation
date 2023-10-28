package fr.jeje.exemples.classes;

public class Voiture {
	//private encapsule les données. Sauf raison particulière, on n'utilisera pas public pour les données. 
	// on écrira avec les setters et on lira avec les getters
	/*
	 * Il est possible, en eclipse de faire:
	 * Source> generate getters and setters
	 * et 	> generate Constructor using fields
	 * ET
	 * menu Refactor > Rename (effet sur getters et setters)
	 * et 			> Encapsulate field
	 */
	
	
	private double qteCarburant;

	private double kilometrage;
	
	//*********** Constructeurs **************
	Voiture(double qteCarburant){
		this.qteCarburant = qteCarburant;
	}
	//*********** Fin Constructeur **************
	
	
	//============ SETTERS ======================
	public void setQteCarburant(double qteCarburant) {
		if(qteCarburant>0 && qteCarburant < 35) {
			this.qteCarburant = qteCarburant;
		}
	}
	
	//pas de setKilometrage, cela se fait en roulant seulement!
	
		
	
	//============ FIN SETTERS ======================
	
	
	//------------- GETTERS ---------------------
	public double getQteCarburant() {
		return qteCarburant;
	}
	
	public double getKilometrage() {
		return kilometrage;
	}
	//------------- FIN GETTERS ---------------------
	
	//$$$$$$$$$$$$$$$ AUTRE METHODES $$$$$$$$$$$$$$$
	void rouler(double distance) {
		kilometrage += distance;
		qteCarburant -= distance*0.07; //mériterait un atribut consommation ^^
	}
	
	
	//$$$$$$$$$$$$$$$ FIN AUTRE METHODES $$$$$$$$$$$$$$$
	
	
}
