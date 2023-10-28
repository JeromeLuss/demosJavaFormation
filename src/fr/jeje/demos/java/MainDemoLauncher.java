package fr.jeje.demos.java;

import java.io.BufferedReader; //pour lire le code
import java.io.File;
import java.io.FileReader; //pour lire le code avec BufferdReader

import java.io.FilenameFilter; //pour la gestion des fichiers du rep

// gestion d'erreurs
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import java.lang.reflect.Method;

import java.util.Scanner;

public class MainDemoLauncher {
	/**
	 * Il faut lancer cette classe pour visualiser toutes les démos Java faites pour l'instant. 
	 * ELle va chercher tous les fichiers .class du package et propose de les lancer
	 * grace à un menu. 
	 * @param args : pas d'argument pour cette classe
	 * 
	 * TODO: ajouter une méthode pour lire les classes, sans execution, en allant les chercher dans le package des classes
	 * 
	 */
	public static void main(String[] args) {
		//File directory = new File("."); //le dossier actuel à la racine sauf que ce sera le rep de travail et pas de java
		//String currentDirectory = System.getProperty("user.dir");

		//je n'y arrive pas, je vais plutôt récupérer le nom du package en cours:
		//SINON plus tard, prévoir un package juste pour les démos et utiliser son chemin à la place!
		String packageName = MainDemoLauncher.class.getPackage().getName();
		//simple replace() pour avoir la fin du chemin
		String packagePath = packageName.replace('.', '/');
		// ajout de ./bin/ pour accéder aux executables
		//attributuion à un objet de la classe File (qui pointera vers le répertoire)
		File directory = new File("./bin/" + packagePath); 

		// File directory = new File(packagePath);
		// https://docs.oracle.com/en/java/javase/20/docs/api/java.base/java/io/File.html
		File[] javaFiles = directory.listFiles(new FilenameFilter() { 
			// https://docs.oracle.com/javase/8/docs/api/java/io/FilenameFilter.html
			// Returns an array of abstract pathnames denoting the files in the directory denoted by this abstract pathname.
			// il faut surcharger accept() pour filtrer sur endsWith ".java"
			@Override
			public boolean accept(File dir, String name) {
				return name.toLowerCase().endsWith(".class");
			}
		});
		/* 
		 * // TEST affichant les fichiers, à virer plus tard 
        for(File fichier : javaFiles) {
        	System.out.println(fichier.getName());
        } 
		 */

		if (javaFiles == null || javaFiles.length == 0) {
			System.out.println("Aucun fichier .class trouvé dans le répertoire courant.");
		} else {

			boolean rester = true;
			do {
				System.out.println("Fichiers .class du répertoire bin du package:");
				System.out.println();

				for (int i = 0; i < javaFiles.length; i++) {

					if(!javaFiles[i].getName().startsWith("MainDemoLauncher")){//ignorer le launcher!
						//try { //j'ai ajouté le chemin complet pour debugg

						System.out.println((i + 1) + ". " + javaFiles[i].getName().replace(".class", ""));// + " " + javaFiles[i].getCanonicalPath());
					}
				}
				System.out.println("0. Pour sortir");
				System.out.println();

				Scanner scanner = new Scanner(System.in);
				System.out.print("Veuillez sélectionner un fichier .class à exécuter "
						+ "pour tester la démo. (entrez le numéro) : ");

				int choice = scanner.nextInt();
				scanner.nextLine(); // Consume the newline character

				if (choice >= 1 && choice <= javaFiles.length) {
					File selectedFile = javaFiles[choice - 1];
					
					//Lecture du code 
					String chemin = selectedFile.getPath() .replace("bin","src").replace("class", "java");
					System.out.println();
					lectureCode(chemin);
					System.out.println();
					
					String classFilePath = packageName + "." + selectedFile.getName().replace(".class", "");
					//ci dessous déjà testé_____________________________________________
					//String classFilePath = selectedFile.getPath().replace(".class", "");
					// Utiliser des barres obliques simples dans le chemin du fichier .class
					//classFilePath = classFilePath.replace("\\", "/");
					//_____________________________________________________________________
					
					

					//DEBUGG
					//String classpath = System.getProperty("java.class.path");
					//System.out.println("Chemin complet où Java cherche les classes : " + classpath);


					try {
						// Charger la classe à partir du chemin du fichier .class
						Class<?> clazz = Class.forName(classFilePath);
						//Class<?> clazz = Class.forName("DemoChaine");
						//Class<?> clazz = Class.forName(classFilePath);

						// Trouver la méthode main dans la classe chargée
						Method mainMethod = clazz.getMethod("main", String[].class);

						// Arguments vides pour le main
						String[] arguments = {};
						
						System.out.println("***************** EXECUTION *****************");
						
						// Appeler la méthode main
						mainMethod.invoke(null, (Object) arguments);
					} catch (ClassNotFoundException e) {
						System.out.println("Classe non trouvée : " + e.getMessage());
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						System.out.println("Méthode main non trouvée : " + e.getMessage());
						e.printStackTrace();
					} catch (IllegalAccessException | InvocationTargetException e) {
						System.out.println("Erreur lors de l'appel de la méthode main : " + e.getMessage());
						e.printStackTrace();
					} catch (Exception e) {
						System.out.println("Une erreur inattendue s'est produite : " + e.getMessage());
						e.printStackTrace();
					}
				} else if(choice == 0) {
					System.out.println("Merci et à plus.");
					System.exit(0);//sortie de l'appli de révision
				}else {
					System.out.println("Choix invalide.");
				}
				System.out.println("**************** FIN EXECUTION ****************");
				System.out.println();
			}while(rester);
		}//end if on a des javaFiles. 
	}//Fin main
	
	public static void lectureCode(String chemin) {
		/**
		 * Lecture du code à l'écran
		 */
		System.out.println("======================= CODE =======================");
		try (BufferedReader reader = new BufferedReader(new FileReader(chemin))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Erreur de lecture du fichier : " + e.getMessage());
        }
		
		System.out.println("===================== FIN CODE =====================");
	}

}//Fin classe


