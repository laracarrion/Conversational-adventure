package tp.pr4.items;

import tp.pr4.*;

public class Key extends PersistentItem{
	
	private Door door;

	//====================================Constructoras==============================================
		public Key(String id, String description, Door door) {
			super(id, description);
			this.door=door;
		}
	//======================================Métodos====================================================

		/*---------------------------------------------------------------------------------------------------------------------
		 * Toggle the state of the door (open-closed / closed-open). In order for the key to be able to perform the action, 
		 * the player should stay on the room the door belongs to. Checks (and opens the door) if this key can be used to go from 
		 * the input parameter where to go to another room thought the door that it opens. 
		 * It returns true if the following situation holds:
			The input parameter where is not null, and
			The door that appears in this object is not null, and
			From the room where we can access the door of this key
		 * Specified by:
			use in class Item
		 * Parameters:
			who - Player that uses the key.
			where - Room where the player stays.
		 * Returns:
			true if the action was performed (the door was open or close accordingly to it previous state).
		 ---------------------------------------------------------------------------------------------------------------------*/
		public boolean use(Player who, Room where) {
			if (door.isInRoom(where)){ 
				
				if(door.isOpen()){ 
					door.close(); 
				}
				else door.open(); 
				System.out.println(Constants.MESSAGE_CHANGES);
				return true;
			}
			else {
				System.out.println(Constants.MESSAGE_CHANGES_ERROR);
				return false;
				
				
			}
			
		
		}

}
