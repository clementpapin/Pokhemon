package menu;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import pokehmon.ListePokehmon;

public class Pokehdex {
	public static void show() {
		afficherTitre();
		System.out.println("\n");
		afficherPokehmons(getPokehdex());
	}

	public static void afficherTitre() {
		char c;

//		System.out.print("\u001b[48;5;11m");
//		System.out.print("\u001b[38;5;20m");
//		System.out.print("\u001b[1m");
		try (FileReader f = new FileReader("res/artwork/TitrePokehdex");) {
			int i = -1;
			do {
				i = f.read();
				c = (char) i;

				if (c != '/' && c != '\\' && c != '_' && c != '<' && c != '\n') {
					System.out.print(" ");
				} else {

					System.out.print(c);
				}

			} while (i != -1);

//			System.out.print("\u001b[48;38;5;0m");
//			System.out.print("\u001b[38;5;255m");

		} catch (Exception e) {
		}
	}

	private static void afficherPokehmons(Map pokehdex) {
		for (ListePokehmon poke : ListePokehmon.values()) {
			System.out.println('\t'+(isInPokehdex(pokehdex, poke.getNom()) ? "\u001b[48;5;11m" :"") +poke.getNom() + "\u001b[48;5;0m");
		}
	}
	
	public static boolean isInPokehdex(Map<String, String> pokehdex, String name) {
		return Integer.parseInt(pokehdex.get(.getNom())) > 0;
	}
	
	public static void sendToPokehdex(String name) {
		
	}
	
	
	private static Map<String, String> getPokehdex() {
		Map<String,String> map = new HashMap<String, String>();
		BufferedReader br = null;
		String line =  null;

		try {
			br = new BufferedReader(new FileReader("res/saves/pokehdex.csv"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

	    try {
			while((line=br.readLine())!=null){
			    String str[] = line.split(",");
			    for(int i=0;i<str.length;i++){
			        String arr[] = str[i].split(":");
			        map.put(arr[0], arr[1]);
			    }
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    System.out.println(map);
	    
		return map;
	}
	
	public static void main(String[] args) {
		show();
	}
}
