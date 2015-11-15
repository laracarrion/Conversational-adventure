package tp.pr4.items;

import tp.pr4.*;

public class Food extends ExpirationItem{

	
	private int value;

	//==================================================Constructoras==================================================	
		//Constructora agua
		public Food (String name, String description, int health, int ntimes){
			super(name, description, ntimes);
			this.value = health;
		}
		
		//Constructora seta, carne
		public Food (String name, String description, int health){
			super(name, description, 1);
			this.value = health;
		}

	//=======================================================Métodos==================================================
		/*-------------------------------------------------------------------------------------------------------------------
		 * Returns true if the player can use this object in this room. The food can be used at any place.
		 * Overrides:
			use in class tp.pr2.ExpirationItem
		 * Parameters:
			who - Player that uses the item.
			where - Location of the player when using it.
		 * Returns:
			true if the item was successfully used.
		-----------------------------------------------------------------------------------------------------------------------*/
		public boolean use(Player who, Room where){
			if(canBeUsed()){
				super.use(who, where);
				who.addHealth(value);
				return true;
			}
			else return false;
		}
}
