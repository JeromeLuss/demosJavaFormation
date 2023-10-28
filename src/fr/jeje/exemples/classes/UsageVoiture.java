package fr.jeje.exemples.classes;

public class UsageVoiture {

	public static void main(String[] args) {
		double qteCarburant = 35;
		
		Voiture v = new Voiture(qteCarburant);
		
		System.out.println(v.getQteCarburant());
		
		v.rouler(100);
		System.out.println(v.getKilometrage());
		
		//v.kilometrage = -12; //non contrôlé si ce n'était pas encapsulé
		
		System.out.println(v.getKilometrage());

		
		System.out.println(v.getQteCarburant());
		
		//__________test vehicule________________
		Vehicule vehi = new Vehicule(20,200);
		vehi.accelerer();
		vehi.freiner();
		
		//vehi.vitesse => impossible car encapsulé par private
		
		
		

	}

}
