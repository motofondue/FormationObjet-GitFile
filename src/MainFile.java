import java.util.List;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class MainFile {
	static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {
		String string = inputString("Entrez un chemin de travail :");

		Path path = Paths.get(string);

		createPathIfNotExists(path);

		string = inputString("Voulez vous une arborescence sur 2 niveaux ? ");
		if (string.equals("oui")) {
			createSubDirectories(path);
			refreshDirectoryContentFile(path);
		}

		// TODO add .directory creation

		// string = inputString("Rentrez le nom d'un fichier à copier : ");
	}

	private static void refreshDirectoryContentFile(Path path) {
		try {
			Path filePath = path.resolve(".directory");
			if (!Files.exists(filePath)) {
				Files.createFile(filePath);
			}

			FileWriter file = new FileWriter(filePath.toFile(), false);
			Stream<Path> entities = Files.list(path);
			
			List<String> files = new ArrayList<String>();
			entities.forEach(p ->files.add(p.toString()));
			
			for (String string : files) {
				Path subPath = Paths.get(string);
				
				file.write(subPath.getFileName().toString());
				file.write(System.lineSeparator());
				
				if (Files.isDirectory(subPath)) {
					refreshDirectoryContentFile(subPath);
				}
			}
			file.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void createSubDirectories(Path path) {
		System.out.println("Creation des sous dossiers");
		createPathIfNotExists(path.resolve("sub1").resolve("sub2"));

	}

	private static void createPathIfNotExists(Path path) {
		if (!Files.exists(path)) {
			try {
				Files.createDirectories(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static String inputString() {
		return inputString("");
	}

	private static String inputString(String question) {
		if (!question.equals("")) {
			System.out.println(question);
		}
		return reader.nextLine();
	}
}
