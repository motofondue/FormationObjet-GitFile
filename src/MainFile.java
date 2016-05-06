import java.util.Scanner;

public class MainFile {
	static Scanner reader = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Entrez un chemin de travail: ");
		String aword = inputWord();
		
	}
	private static String inputWord() {
		return reader.nextLine();
	}
}
