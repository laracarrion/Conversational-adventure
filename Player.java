package tp.pr4;

import java.util.ArrayList;

import tp.pr4.gui.*;
import tp.pr4.items.Item;

public class Player {
	private int health;
	private int score;
	private ArrayList<Item> items; 

//=====================================Constructoras=================================================
	public Player(){//por defecto
		this.health = 100;
		this.score = 0;
		this.items = new ArrayList<Item>();
	}
	
	public Player(int health, int score) {//con parámetros
		this.health = health;
		this.score = score;
		this.items = new ArrayList<Item>();
	}
//=====================================Métodos=================================================
	
	
	/*----------------------------------------------------------------------------------------------
	 * Add an item in the inventory
	 * Parameters:
		item - The name of the item must be unique in the player inventory.
	 * Returns:
		true if the item was added and false when the player already had an item with the same name.
	 ----------------------------------------------------------------------------------------------*/
	public boolean addItem (Item id){ //para a–adirlo no tiene q estar en el arraylist de items
		int i=0;
		boolean encontrado = false;
		
		while (i<this.items.size() && !encontrado){ //lo busco
			if(this.items.get(i).getId().equalsIgnoreCase(id.getId())) return false;
			else i++;
		}
		
		if (!encontrado) { //el item no est‡ en el arraylist y quiero agregar el q m entra por par‡metro
			items.add(id); //lo agrego al arraylist con el método convencional
			return true;
		}
		
		else return false;
	}	
	
	
	/*----------------------------------------------------------------------------------------------
	 * Checks if an item is in the bag 
	 * If it does not exist it returns false .
	 * Parameters:
		it - Item id
	 * Returns:
		True if the item exists. False if it does not.
	 ----------------------------------------------------------------------------------------------*/
	public boolean hayItem (String it){ // metemos por par‡metro un id (seta, agua, carne) 
		int i=0;
		boolean encontrado = false;
		while (i < this.items.size() && !encontrado){
			if (this.items.get(i).getId().equalsIgnoreCase(it)) return true;
			else i++;
		}
		return false;
	}
	
	/*----------------------------------------------------------------------------------------------
	 * Returns the position of a given item
	 ----------------------------------------------------------------------------------------------*/
	public int getPosicionItem (String item) {
		int i = 0;
		boolean encontrado = false;
		while(i<this.items.size() && !encontrado) {
			encontrado = this.items.get(i).getId().equalsIgnoreCase(item);
			i++;
			
		}
		if (encontrado) return i-1;
		else return -1;
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
		else return false;
	}
	
	/*----------------------------------------------------------------------------------------------
	 * Returns the item in the given position 
	 ----------------------------------------------------------------------------------------------*/
	public Item itemByPosition(int pos) {
		if(pos>=0 && pos<this.items.size()) return this.items.get(pos);
		else return null;
	}
	
	
	/*----------------------------------------------------------------------------------------------
	 * Returns the item from the inventory according to the item name. It returns the Item. 
	 * If it does not exist it returns null.
	 * Parameters:
		id - Item name
	 * Returns:
		Item with that name or null if the player does not have an item with this name that item.
	 ----------------------------------------------------------------------------------------------*/
	public Item getItem (String id){
		int i=0;
		boolean encontrado = false;
		
		while(i<this.items.size() && !encontrado) {
			encontrado = hayItem(id);
			if (encontrado) return this.items.get(i);
			i++;
		}
		return null;
	}
	
	/*-----------------------------------------------------------------------------------------------
	 * Delete a given item from the inventory.
	 * Parameters:
	  	id - Name of the item
	 * Returns:
		true if the player had that item and it was removed from the inventory.
	 -----------------------------------------------------------------------------------------------*/
	public boolean removeItem (String id){
		int i=0;
		boolean encontrado = false;
		while(i<this.items.size() && !encontrado){
			encontrado = hayItem(id);
			if(encontrado){
				this.items.remove(i);
				return true;
			}
			else i++;
		}
		return false;
	}
		
	/*------------------------------------------------------------------------------------------------------------
	 * Checks if the player is dead
	 * Returns:
		true if the health <=0
	 ------------------------------------------------------------------------------------------------------------*/
	public boolean dead(){
		return this.health<=0;
	}
	
	/*------------------------------------------------------------------------------------------------------------
	 * Returns the player scoring
	 * Returns:
		Current points.
	 ------------------------------------------------------------------------------------------------------------*/
	public int getPoints(){
		return this.score;
	}
	
	/*------------------------------------------------------------------------------------------------------------
	 * Sum the value of points.
	 * Parameters:
		points - Points to be added. It could be a negative number and therefore the player may have negative points.
	------------------------------------------------------------------------------------------------------------ */
	public void addPoints(int points){
		this.score+=points;
	}
	
	/*------------------------------------------------------------------------------------------------------------
	 * Returns the player health
	 * Returns:
		The health of the player. It is always a number greater or equal to zero.
	 ------------------------------------------------------------------------------------------------------------*/
	public int getHealth (){
		if(this.health >= 0)
		return this.health;
		else return 0;
	}
	
	/*------------------------------------------------------------------------------------------------------------
	 * The health is updated.
	 * Parameters:
		health - Quantity of health that is gain. It could be negative, but the method guarantees that the player 
		has no negative health.
	 ------------------------------------------------------------------------------------------------------------*/
	public void addHealth(int health){
		if(this.health> 0)
			this.health+=health;
	}
	
	/*------------------------------------------------------------------------------------------------------------
	 * Shows the items carried by the player.
	 * Returns:
		A string with the names of the items contained in the player inventory
	 ------------------------------------------------------------------------------------------------------------*/
	public String showItems(){
		String s="";
		if (this.items.isEmpty()) s = Constants.MESSAGE_POOR;
		
		else
			for (int i=0;i<this.items.size();i++)

				s += this.itemByPosition(i).toString()+Constants.LINE_SEPARATOR;
		
		return s;
	
	}
	
	public String toString(){
		String s="";
		s += Constants.MESSAGE_PLAYER_TOSTRING_HEALTH + this.getHealth() + Constants.MESSAGE_PLAYER_TOSTRING_SCORE + this.getPoints();
		return s;
	}
	
	/*
	 * Establishes the panel where the player will update its information on the Swing interface
	 */
	public void setPlayerPanel(PlayerPanel playerPanel){
		
	}
}
