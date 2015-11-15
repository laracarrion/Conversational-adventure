package tp.pr4.items;

public abstract class PersistentItem extends Item{
	//====================================Constructoras==============================================
	public PersistentItem(String id, String description) {
		super(id, description);
	
	}
	
//====================================Métodos==============================================

	/*------------------------------------------------------------------------------------------------------------------------
	 * The persistent items can be used always, thus this method returns always true.
	 * Specified by:
		canBeUsed in class Item
	 * Returns:
	 	always true 'cause it can always be used
	------------------------------------------------------------------------------------------------------------------------*/
	public boolean canBeUsed() {

		return true;
	}

}
