package tp.pr4;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import tp.pr4.maploader.MapLoaderFromTxtFile;
import tp.pr4.maploader.exceptions.WrongMapFormatException;

public class Main {
	/*|---------------------+---------------|
	| *Entrada*           | *Salida*      |
	| Agua                |               |
	| Carne en mal estado |               |
	|------  BID   -------+---- BID  -----|
	| *Pasillo*           | *Sal—n*       |
	| Llave puerta 3     UNID             |
	|                     | Moneda de oro |
	|---------------------+---------------|
	/**
	 * Create the rooms and configure the initial current room.
	 * 
	 * @return The room where the player starts the game
	 */

	/**
	 * Main method
	 * 
	 * @param args
	 * @throws IOException 
	 * @throws WrongMapFormatException 
	 */
	
	public static void main(String[] args) throws IOException, WrongMapFormatException {

		String s="";
		
		if (args.length!=1){
			System.err.println("No map file specified." + Constants.LINE_SEPARATOR + Constants.LINE_SEPARATOR + "Usage: tp.pr4.Main <mapFile>" + Constants.LINE_SEPARATOR);
			System.exit(1);

		}
		s=args[0];
		
		Map m=new Map(null);
		MapLoaderFromTxtFile mapa = new MapLoaderFromTxtFile();
		
		try{
			FileInputStream input= new FileInputStream(new File(s));
			m= mapa.loadMap(input);
			Game g = new Game(m);
			g.runGame();
			System.exit(0);
		}
		catch(IOException e){
			System.err.println(e.getMessage());
			System.exit(1);
		}
			
		
		System.exit(0);
		}
}
