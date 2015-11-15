package tp.pr4;

import java.util.ArrayList;

import tp.pr4.gui.*;

public class Map {
	private ArrayList<Door> puertas;
	private Room current;
	/**====================================Constructora==============================================
	 * 
	 */
		public Map(){
			this.current=null;
			this.puertas = new ArrayList<Door>();
		}
		
	public Map(Room room) {
		this.current = room;
		this.puertas = new ArrayList<Door>();
		
		
	}

	/**======================================Métodos=================================================
		
		/**------------------------------------------------------------------------------------------------------
		 * Create a new door between the rooms given as parameters, adds it to the map and returns it.
		 * Parameters:
		   source - The start-side of the door.
		   direction - Position of the door in the source room.
		   target - The end-side of the door. 
		 * Returns:
		   New door just created. Users may then set its properties (open-closed). 
		   It returns null if there was problems during the creation.
		------------------------------------------------------------------------------------------------------*/
		public Door addDoor(Room source, Directions direction, Room target){
			
			if ((source!=null) && (target!=null) && (!direction.equals(Directions.UNKNOWN))){
				Door d = new Door(source, direction, target, false, true);
				this.puertas.add(d);
				return d;
			}
			else return null;
		}
		
		/**
		 * Añade una puerta ya creada
		 * 
		 */
		
		public void addDoor(Door d){
			if (d!=null) this.puertas.add(d);
		}
		
		/**------------------------------------------------------------------------------------------------------
		 * Similar to addDoor method but creating a door that may be traversed in both directions.
	     * Parameters:
	     	source - The start-side of the door.
	     	direction - Position of the door in the source room.
	     	target - The end-side of the door. 
	     * Returns:
	     	New door just created. Users may then set its properties (open-closed). 
	       	It returns null if there was problems during the creation.
		 ------------------------------------------------------------------------------------------------------*/
	
		
		public Door addBidirectionalDoor(Room source, Directions direction, Room target){
			
			Door d = new Door(source, direction, target, true,true);
				this.puertas.add(d);
				return d; 
			
		}	
		
		public ArrayList<Door> getPuertas() {
			return puertas;
		}

		public void setPuertas(ArrayList<Door> puertas) {
			if(puertas!=null) this.puertas = puertas;
		}

		/**------------------------------------------------------------------------------------------------------
		 * Returns the door that is in a Direction of a Room. 
		 * Let us note that may be this door can not be used (if it is closed), but we don't care.
		 * Parameters:
		 	room - The room where the player stays
		  	dir - The direction to be checked 
		 * Returns:
		 	The door in the room at the given direction (or null if there is no door).
		 ------------------------------------------------------------------------------------------------------*/
		public Door getDoor (Room room, Directions direction){
			
				int i=0;
				Door d = null;
				boolean encontrado = false;
				while((i<this.puertas.size())&& !encontrado){
					encontrado = (this.puertas.get(i).isInRoom(room, direction));
					if(encontrado) d = this.puertas.get(i);
					i++;
				}
				return d;
		}
		
		/**
		 * Returns a reference to the room where the player is currently located. 
		 * This method is employed only by the unit tests.
		 * 
		 * @return A reference to the current room
		 */
		public Room getCurrentRoom(){
			return this.current;
		}
		
		/**
		 * Establishes the current room
		 * 
		 * @param currentRoom - the currentRoom to set
		 */
		public void setCurrentRoom(Room currentRoom){
			this.current=currentRoom;
		}
		
		/*
		 * Establishes the panel that will show the map on the Swing interface
		 */
		public void setMapPanel(MapPanel mapPanel){
			
		}
}
