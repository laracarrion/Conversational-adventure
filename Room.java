package tp.pr4;

import java.util.ArrayList;

import tp.pr4.items.Item;
import tp.pr4.gui.*;

public class Room {
	private String descripcion;
	private boolean salida;
	private ArrayList<Item> items;
  //============================================Constructoras=========================================	
	public Room(){
		this.descripcion = "";
		this.salida = false;
		this.items = new ArrayList<Item>();
	}
	
	public Room (boolean exit, String description) {
		this.descripcion = description;
		this.salida = exit;
		this.items = new ArrayList<Item>();
	}
	
	public Room(boolean exit, String description,Item[] its){ //controlar si el array tiene elementos duplicados
		
		this.descripcion = description;
		this.salida = exit;
		this.items = new ArrayList<Item>();
		for(int i = 0; i < its.length;i++)
			if(!existsItem(its[i].getId())){ 
				this.items.add(its[i]); }
	    }
	
  //======================================Métodos==============================================
	
	/*------------------------------------------------------------------------------------------------------------------------
	 * Returns the room description and a list with the ids of the items and their description that belongs to this room. <> <>
	 * Returns:
		The room description	
	------------------------------------------------------------------------------------------------------------------------*/
	public String getDescription() {
		String s1 = this.descripcion;
		String s2 = Constants.MESSAGE_ITEMS_ROOM;
		String s4 = Constants.MESSAGE_NO_ITEMS;
		String s3 = "";
		
		if(this.items.isEmpty())
			return s1 + Constants.LINE_SEPARATOR + s4;
		
		
		else{
			
		  if(this.items.size()==1) s3+=this.items.get(0).toString();
		  else	{
			for (int i=0; i<this.items.size()-1; i++){
				s3+= this.items.get(i).toString() + Constants.LINE_SEPARATOR;
			}		
			s3+=this.items.get(this.items.size()-1).toString();
		  }
		  return s1 + Constants.LINE_SEPARATOR + s2 + Constants.LINE_SEPARATOR + s3; 
	   }
	}
	
	
	/*------------------------------------------------------------------------------------------------------------------------
	 * Pick an item from the room and add it to the player's inventory.
	 * Parameters:
		who - the player
	 * id - the identifier of the item
	 * Returns:
		true if the action was successfully performed.
	------------------------------------------------------------------------------------------------------------------------*/
	public boolean pickItem(Player who, String id){
		int i=0;
		boolean encontrado= false;
		while (i<items.size() && !encontrado){
			if (this.items.get(i).getId().equalsIgnoreCase(id)) {
					Item item = this.items.get(i); //guardo el item
					who.addItem(item);//lo meto en el arraylist del jugador
					removeByPosition(i); 
					encontrado=true; //se ha añadido con éxito = true
			}
			else i++;
		
		}
		return encontrado;
	}
	
	/*----------------------------------------------------------------------------------------------
	 * Removes the item in the given position
	 * Returns
	 	true if the item has been properly removed
	 	false otherwise
	 ----------------------------------------------------------------------------------------------*/
	public boolean removeByPosition(int pos){
		if(pos>=0 && pos<this.items.size()) {
			this.items.remove(pos);
			return true;
		}
		return false;
	}
	
	/*---------------------------------------------------------------------------------------------------------------------
	 * Return true if the Item <> exists.
	 * Parameters:
		id - Name of the item.
	 * Returns:
		true if the room as an item with that name.
	 ---------------------------------------------------------------------------------------------------------------------*/
	
	public boolean existsItem(String id){
			return this.getPosition(id) < this.items.size(); 
	}
	
	
	/*---------------------------------------------------------------------------------------------------------------------
	 *  Set the item description
	 * Returns:
	 	void
	 ---------------------------------------------------------------------------------------------------------------------*/
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	/*---------------------------------------------------------------------------------------------------------------------
	 * Is it an exit room?
	 * Returns:
		true if it is an exit room
	 ---------------------------------------------------------------------------------------------------------------------*/
	public boolean isExit() {
		return this.salida; 
	}
	
	/*---------------------------------------------------------------------------------------------------------------------
	 * Returns the item position 
	 * Returns:
	 	the position if the item is in the room
	 ---------------------------------------------------------------------------------------------------------------------*/
	public int getPosition(String id)
	{
		int i = 0; 
		boolean encontrado = false;
		while(i < this.items.size() && ! encontrado){
			encontrado = this.items.get(i).getId().equalsIgnoreCase(id);
			 if (!encontrado)i++;}
		return i;
	}
	
	/*--------------------------------------------------------------------------------------------------------------------- 
	 * Add a given item. The name (id) of the item should be unique in the room.
	 * Parameters:
		it - Item to be added
	 * Returns:
		true if the action was completed.
	 ---------------------------------------------------------------------------------------------------------------------*/
	public boolean addItem(Item it){
		int i= 0;
		boolean encontrado = false;
		while(i<this.items.size() && !encontrado){
			if(this.getItemByPosition(i).getId().equalsIgnoreCase(it.getId())) encontrado = true;//si hay un item con ese id no lo mete
			else i++;
		}
		if(!encontrado)//si no ha encontrado un item con ese nombre lo mete
			this.items.add(it);
		
		return !encontrado;
			
	}
	
	public Item getItemByPosition(int pos){
		if(pos>=0 && pos<this.items.size()) {
			for(int i=0; i<this.items.size(); i++){
				if (i==pos){
					return this.items.get(i);
				}
			}
		}
			return null;
	}
	
	/*
	 * Shows on Swing interface that the player enters this room
	 */
	public void enterRoom(MapCell cell){
		
	}
	
	/*
	 * Shows on Swing interface that the player leaves this room
	 */
	public void leaveRoom(){
		
	}
}
