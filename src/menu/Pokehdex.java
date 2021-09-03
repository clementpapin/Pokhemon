package menu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import plateau.ChargerPlateau;
import pokehmon.ListePokehmon;

public class Pokehdex {
	public static final File savedir = new File(new File(System.getProperty("user.home")), "pokehmon");

	public static void show() {
		afficherTitre();
		System.out.println("\n");
		afficherPokehmons(getPokehdex());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("\nAppuyez sur entrée pour quitter le pokehdex...");
		try {
			br.readLine();
		} catch (IOException e) {}
		System.out.println("\n\n\n");
	}

	public static void afficherTitre() {
		char c;
		System.out.print("\u001b[48;5;15m");
		System.out.print("\u001b[38;5;124m");
		InputStream in = ChargerPlateau.class.getResourceAsStream("/artwork/TitrePokehdex"); 
		try (InputStreamReader f = new InputStreamReader(in);) {
			int i = -1;
			do {
				i = f.read();
				c = (char) i;
				System.out.print("\u001b[48;5;15m");
				if(c != '/' && c != '\\' && c != '_' && c != '<' && c !='\n') {
					System.out.print(" ");
				} else if(c == '\n'){
					System.out.print("\u001b[48;5;236m\n");
				} else {
					System.out.print(c);
				}
				System.out.print("\u001b[48;5;236m");

			} while (i != -1);

		} catch (Exception e) {}
		System.out.print("\u001b[38;5;255m");
		System.out.print("\u001b[48;38;0m");
	}

	private static void afficherPokehmons(Map<String, String> pokehdex) {
		for (ListePokehmon poke : ListePokehmon.values()) {
			System.out.println('\t'+(isInPokehdex(pokehdex, poke.getNom()) 
					? "\u001b[48;5;47m\u001b[38;5;236m" :"") +poke.getNom() 
					+ "\u001b[48;38;5;0m\u001b[38;5;255m");
		}
	}

	public static boolean isInPokehdex(Map<String, String> pokehdex, String name) {
		if(pokehdex.get(name) == null) return false; 
		return Integer.parseInt(pokehdex.get(name)) > 0;
	}

	public static void sendToPokehdex(String name) {
		savedir.mkdir();
		try {
			File myObj = new File(savedir, "pokehdex.csv");
			myObj.createNewFile();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		Map<String, String> map = getPokehdex();
		boolean deja_attrape = false;
		for (String key : map.keySet()) {
			if(key.equalsIgnoreCase(name)) {
				int nbCaptures = Integer.parseInt(map.get(key))+1;
				map.put(key, nbCaptures+"");
				deja_attrape = true;
			}
		}
		if(!deja_attrape) {
			map.put(name, "1");
		}
		try(FileWriter fw = new FileWriter(new File(savedir, "pokehdex.csv"));) {
			for (String key : map.keySet()) {
				fw.append(key+":"+map.get(key)+",");
				fw.write("");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static Map<String, String> getPokehdex() {
		savedir.mkdir();
		try {
			File myObj = new File(savedir, "pokehdex.csv");
			myObj.createNewFile();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		Map<String,String> map = new HashMap<String, String>();
		BufferedReader br = null;
		String line =  null;

		try(FileReader fr = new FileReader(new File(savedir, "pokehdex.csv"));) {
			br = new BufferedReader(fr);
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

		return map;
	}
	public static void reset() {
		try(FileWriter fw = new FileWriter(new File(savedir, "pokehdex.csv"));) {
			fw.write("");
		} catch (IOException e) {
		}
	}
}