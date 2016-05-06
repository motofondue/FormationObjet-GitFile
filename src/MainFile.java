import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class MainFile {
	static Scanner reader = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Entrez un chemin de travail :");
		String string = inputString();
		
		Path path = Paths.get(string);
		
		createPathIfNotExists(path);
		
		System.out.println("Voulez vous une arborescence sur 2 niveaux ? ");
		string = inputString();
		if (string.equals("oui")) {
			createSubDirectories(path);
		}
	}

	private static void createSubDirectories(Path path) {
		// TODO Creation
		System.out.println("Creation des sous dossiers");
	}

	private static void createPathIfNotExists(Path path) {
		if (!Files.exists(path)){
			try {
				Files.createDirectory(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static String inputString() {
		return reader.nextLine();
	}
}
