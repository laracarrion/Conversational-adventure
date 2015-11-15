package tp.pr4.items;

import tp.pr4.*;
public abstract class Item {
	
	
	private String idItem;
	private String desc;
	

	
//====================================Constructoras==============================================
	protected Item (String id, String description){
		this.idItem = id;
		this.desc = description;
		
	}
//======================================Métodos====================================================

 /*---------------------------------------------------------------------------------------------------------------------
  * Returns the item name (or ID)
  * Returns:
		The id.
 ---------------------------------------------------------------------------------------------------------------------*/
	public String getId() {
		return this.idItem;
	}
	
	public void setId(String s) {
		this.idItem = s;
	}
	
 /*---------------------------------------------------------------------------------------------------------------------
  * Returns the description of an item
  * Returns:
	 The description
 ---------------------------------------------------------------------------------------------------------------------*/
	public String getDescription() { 
		return this.desc;
	}
	
 /*---------------------------------------------------------------------------------------------------------------------
  * Method that returns a string with information about an Item. The pattern is: --item[<>]=<>
  * Overrides:
		toString in class java.lang.Object
  * Returns:
	  The string with the item information
  ---------------------------------------------------------------------------------------------------------------------*/
	public String toString() {
		return "--item["+this.idItem+ "]="+this.desc;
	}
	
 /*---------------------------------------------------------------------------------------------------------------------
  * Method called when using the item. Derived classes must implement the method.
  * Parameters:
	 who - Player that uses the item.
	 where - Location of the player when using it.
  * Returns:
	 true if the item was successfully used.
 ---------------------------------------------------------------------------------------------------------------------*/
	public abstract boolean use (Player who, Room where);
	
 /*---------------------------------------------------------------------------------------------------------------------
  * Depending on the type of the item, it could be used forever (a key) or just a limited number of times (food and valuable). 
  * This method returns true when the item can be used at lest once more time.
  * Returns:
	 true if the item can be used. This does not guarantee that the invocation to use method returns true, 
	 because player could try to use it on a wrong location, etc.
 ---------------------------------------------------------------------------------------------------------------------*/
	public abstract boolean canBeUsed();



}
