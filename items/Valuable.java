package tp.pr4.items;

import tp.pr4.*;

public class Valuable extends ExpirationItem {
	
	
	private int ntimes;
	private int puntos;

  //============================================Constructora===========================================
	public Valuable(String id, String description, int score) {
		super(id, description,1);
		this.ntimes= 1;
		this.puntos=score;
	}
	
	//============================================Métodos===============================================
	
	/*------------------------------------------------------------------------------------------------------------------
	 * The points are added to the player.
	 * Overrides:
		use in class tp.pr2.ExpirationItem
	 * Parameters:
		who - Player that uses the item.
		where - Location of the player when using it.
	 * Returns:
		true if the action could take place.
	------------------------------------------------------------------------------------------------------------------*/
	public boolean use (Player who, Room where){
		if(canBeUsed()) {
			super.use(who, where);
			who.addPoints(this.puntos);
			return true;
		}
		else return false;
	}

}
