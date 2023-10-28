package fr.jeje.demos.java;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class MainDemoLauncher_DRAFT {
	/**
	 * 
	 * @param args : pas d'argument pour cette classe
	 * 
	 */
    public static void main(String[] args) {
        //File directory = new File("."); //le dossier actuel à la racine sauf que ce sera le rep de travail et pas de java
        //String currentDirectory = System.getProperty("user.dir");
    	
    	//je n'y arrive pas, je vais plutôt récupérer le nom du package en cours:
    	//SINON plus tard, prévoir un package juste pour les démos et utiliser son chemin à la place!
    	String packageName = MainDemoLauncher.class.getPackage().getName();
    	String packagePath = packageName.replace('.', '/');
    	File directory = new File("./bin/" + packagePath); // Assurez-vous de spécifier le bon chemin vers votre dossier source
    	
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
            System.out.println("Aucun fichier .java trouvé dans le répertoire courant.");
        } else {
            System.out.println("Fichiers .java trouvés dans le répertoire courant:");
            
            int comptMenu =1;
            for (int i = 0; i < javaFiles.length; i++) {
            	
            	if(!javaFiles[i].getName().startsWith("MainDemoLauncher")){//ignorer le launcher!
            		try { //j'ai ajouté le chemin complet pour debugg
						System.out.println((i + 1) + ". " + javaFiles[i].getName() + " " + javaFiles[i].getCanonicalPath());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            		comptMenu++;
            	}
            }

            Scanner scanner = new Scanner(System.in);
            System.out.print("Veuillez sélectionner un fichier .java à exécuter (entrez le numéro) : ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (choice >= 1 && choice <= javaFiles.length) {
                File selectedFile = javaFiles[choice - 1];
                String classFilePath = packageName + "." + selectedFile.getName().replace(".class", "");
                //ci dessous déjà testé_____________________________________________
                //String classFilePath = selectedFile.getPath().replace(".class", "");
                // Utiliser des barres obliques simples dans le chemin du fichier .class
                //classFilePath = classFilePath.replace("\\", "/");
                //_____________________________________________________________________
                
                
                //DEBUGG
                String classpath = System.getProperty("java.class.path");
                System.out.println("Chemin complet où Java cherche les classes : " + classpath);
                
                
                try {
                    // Charger la classe à partir du chemin du fichier .class
                    Class<?> clazz = Class.forName(classFilePath);
                    //Class<?> clazz = Class.forName("DemoChaine");
                    //Class<?> clazz = Class.forName(classFilePath);

                    // Trouver la méthode main dans la classe chargée
                    Method mainMethod = clazz.getMethod("main", String[].class);

                    // Arguments vides pour le main
                    String[] arguments = {};

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
            } else {
                System.out.println("Choix invalide.");
            }
        }
    }
}

