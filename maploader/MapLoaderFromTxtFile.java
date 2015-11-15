package tp.pr4.maploader;

import java.io.*;
import java.util.ArrayList;
import tp.pr4.*;
import tp.pr4.items.*;
import tp.pr4.maploader.exceptions.*;


public class MapLoaderFromTxtFile {
	
public MapLoaderFromTxtFile(){}
	
	/**
	 * Carga el mapa descrito en file
	 * @param file
	 * @return
	 * @throws IOException
	 * @throws WrongMapFormatException 
	 */
	
	public Map loadMap (InputStream file) throws IOException, WrongMapFormatException{
		BufferedReader br=null;
		try{ 
			
			
				InputStreamReader archivo = new InputStreamReader(file);
				br=new BufferedReader(archivo);
				Map mapa = new Map();
				
				ArrayList<Room> habs = new ArrayList<Room>(); 
				ArrayList<Door> ptas = new ArrayList<Door>(); 
				
				String s;
				s= br.readLine();
				if (s.equalsIgnoreCase("BeginMap")){
					s=br.readLine();
					
					
					while ((!(s.equalsIgnoreCase("EndMap"))) && (s != null)){
						habs=guardarRooms(file, br,s);
						s=br.readLine();
						
						while ((!(s.equalsIgnoreCase("BeginDoors"))) && (s != null))
							s=br.readLine();
						
						ptas = guardarDoors(file,habs,mapa, br,s);
						mapa.setPuertas(ptas);
						s=br.readLine();
						
						while((!(s.equalsIgnoreCase("BeginItems"))) && (s != null))
							s=br.readLine();
						
						guardarItems(habs,ptas,file, br,s);
						s=br.readLine();
					}	
				} 
				mapa.setCurrentRoom(habs.get(0));//habitacion inicial
				br.close();
				return mapa;
		}
		catch (Exception e){
			throw new WrongMapFormatException();
			}	
	}
	
	/**
	 * Guarda las habitaciones que entran por file en una ArrayList
	 * @param file
	 * @param s 
	 * @param mapa
	 * @return
	 * @throws IOException
	 * @throws WrongMapFormatException 
	 */
	public ArrayList<Room> guardarRooms(InputStream file, BufferedReader br, String s) throws IOException, WrongMapFormatException{
	
				
				String[] h ;
				
				String[] bb; 
				
				String roomDescription = "";
				Room r=null;
				ArrayList<Room> hab = new ArrayList<Room>();
				
				if (s.equalsIgnoreCase("BeginRooms")){
					s=br.readLine();
					h= s.split(" ");
				
					
					int j=0;	
				
					while (!(s.equalsIgnoreCase("EndRooms"))){
						roomDescription = "";
						h=s.split(" ");
						if (Integer.parseInt(h[1])==j){
							bb= h[3].split("_");
							for (int i=0; i<bb.length;i++) {
								if(i!=bb.length-1){
								roomDescription = roomDescription + bb[i] + " ";
								}
								else roomDescription = roomDescription + bb[i];
							} //end for
						
							if (h[0].equalsIgnoreCase("room")){/
								if (h[4].equalsIgnoreCase("exit")){
									r = new Room(true,roomDescription);
									hab.add(r);
							}//end if
							
							else if (h[4].equalsIgnoreCase("noexit")){
								r = new Room(false,roomDescription);
								hab.add(r);
							}	//end else if
							}//else if
							j++;
							s=br.readLine();
						}else throw new WrongMapFormatException("La primera hab no es la 0");
					}//end while
				}
				
	
				return hab;
	
		}
	
	/**
	 * Guarda los items que entran por file en cada habitacion de mapa
	 * @param file
	 * @param s 
	 * @param mapa
	 * @throws WrongMapFormatException
	 */
	public void guardarItems(ArrayList<Room> room, ArrayList<Door> door,InputStream file, BufferedReader br, String s) throws WrongMapFormatException {
		try{
			String[] item; 
			String [] bb; 
			String itemDescription = "";
			Item it=null;
			if (s.equalsIgnoreCase("BeginItems")){
				s=br.readLine();
				
				int j=0;
				
				while (!(s.equalsIgnoreCase("EndItems"))){
					itemDescription="";
					item = s.split(" ");
					
					if (Integer.parseInt(item[1])==j){
						
						bb = item[3].split("_"); 
						
						for (int i=0; i<bb.length; i++) {
							if(i!=bb.length-1) {
								itemDescription = itemDescription + bb[i] + " ";
							}
							else itemDescription = itemDescription + bb[i];
						}
					
						if (item[0].equalsIgnoreCase("food")){
							if (hayRoom(room,item[7])==null) throw new WrongMapFormatException();
							else
							if (item[5].equalsIgnoreCase("1"))
								it = new Food(item[2], itemDescription, Integer.parseInt(item[4]));
							else it = new Food(item[2], itemDescription,Integer.parseInt(item[4]),Integer.parseInt(item[5]));
							hayRoom(room, item[7]).addItem(it);
						}else if (item[0].equalsIgnoreCase("key")){
							if(hayDoor(door, item[5]) ==null)
							throw new WrongMapFormatException("kjsdnof");
							else{
							it = new Key(item[2], itemDescription, hayDoor(door, item[5]));
							hayRoom(room, item[7]).addItem(it);
							}
						}else if (item[0].equalsIgnoreCase("valuable")){
							if (hayRoom(room,item[6])==null) 
							throw new WrongMapFormatException("f3wed");
							else{
							it = new Valuable(item[2], itemDescription,Integer.parseInt(item[4]));
							hayRoom(room,item[6]).addItem(it);
							}
						}
					j++;
					s=br.readLine();
				}
					else throw new WrongMapFormatException("El primer item no es el 0");
				}		
			}
		}
		catch (Exception e){
			throw new WrongMapFormatException();
		}
	}

	/**
	 * Busca la puerta de la posicion  que entra por item
	 * @param door
	 * @param item
	 * @return
	 */
	public Door hayDoor(ArrayList<Door> door, String item) {
		Door d=null;
		int i= Integer.parseInt(item);
		if (i<door.size())
			d=door.get(i);
		return d;
	}

	
	/**
	 * Lee las puertas de file y las mete en el arrayList de mapa
	 * @param file
	 * @param mapa
	 * @param s 
	 * @return
	 * @throws WrongMapFormatException
	 */
	public ArrayList<Door> guardarDoors(InputStream file, ArrayList<Room> r,Map mapa, BufferedReader br, String s) throws WrongMapFormatException{
		try{
			Room source=null;
			Room target=null;
			Directions dir=null;
			String[] door;
			ArrayList<Door> doors= new ArrayList<Door>();
			if (s.equalsIgnoreCase("BeginDoors")){
				s=br.readLine();
				
				int i=0;
				
				while (!(s.equalsIgnoreCase("EndDoors"))){
					door = s.split(" ");
					
					if (Integer.parseInt(door[1])==i){
					
						if (door[0].equalsIgnoreCase("door"))
						
						if ((hayRoom(r,door[4])==null)||(hayRoom(r,door[7])==null))
							throw new WrongMapFormatException("");
						else{
							source=hayRoom(r,door[4]);
							target=hayRoom(r,door[7]);
							
							if (hayDir(door[5])!=null) dir=hayDir(door[5]);
							
							if (door[2].equalsIgnoreCase("bidirectional")){
								
								if (door[8].equalsIgnoreCase("open"))
									mapa.addBidirectionalDoor(source, dir, target).open();
								else if (door[8].equalsIgnoreCase("closed"))
									mapa.addBidirectionalDoor(source, dir, target).close();
								}
							
							else if (door[2].equalsIgnoreCase("directional"))
								if(door[8].equalsIgnoreCase("open")) mapa.addDoor(source, dir, target).open();
								else if (door[8].equalsIgnoreCase("closed")) mapa.addDoor(source, dir, target).close();
						}
					i++;
					s=br.readLine();
				}//end while
					else throw new WrongMapFormatException("La primera puerta no es la 0");
				}
				return mapa.getPuertas();
			}	
	}
		catch(Exception e){
			
			throw new WrongMapFormatException("Comando no válido");
		}
		return null;
	}

	/**
	 * Transforma s en una direccion, si se corresponde con una de las predefinidas
	 * @param s
	 * @return
	 */
	public Directions hayDir(String s) {

		if (s.equalsIgnoreCase(Directions.EAST.name())) return Directions.EAST;
		if (s.equalsIgnoreCase(Directions.NORTH.name())) return Directions.NORTH;
		if (s.equalsIgnoreCase(Directions.WEST.name())) return Directions.WEST;
		if (s.equalsIgnoreCase(Directions.SOUTH.name())) return Directions.SOUTH;
		return null;
	}
	
	/**
	 * 
	 * @param r
	 * @param s
	 * @return
	 */
	public Room hayRoom(ArrayList<Room> r, String s) {
		int i=Integer.parseInt(s);
		Room h=null;
		if (i<r.size()) h=r.get(i);
		return h;
	}

}
