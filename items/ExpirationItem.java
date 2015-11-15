package tp.pr4.items;

import tp.pr4.*;

public class ExpirationItem extends Item {
	
	private int ntimes;

	//==================================================Constructoras=================================================
		//valuables y agua
		public ExpirationItem (String id, String description, int ntimes){
			super (id, description);
			this.ntimes = ntimes;
		}
		
		//carne
		public ExpirationItem (String id, String description){
			super (id, description);
			this.ntimes=1;
		}
	//=======================================================Metodos==================================================
		
		/*------------------------------------------------------------------------------------------------------------------------
		 *Each time that an Expiration Item is used, its live is reduced in one unit. By default this method returns true 
		 *and it reduces the live of the object.
		 * Specified by:
			use in class Item
		 * Returns:
		   true if ntimes > 0 and ntimes can be reduced. false if ntimes is 0 or less than 0.  
		 ------------------------------------------------------------------------------------------------------------------------*/
		public boolean use(Player who, Room where) {
			if(this.ntimes>0){
				this.ntimes--;
				System.out.println(Constants.MESSAGE_CHANGES);
				return true;
			} 
			else return false;
		}
		
		/*------------------------------------------------------------------------------------------------------------------------
		 * Returns true if this object can be used at least one time.
		 * Specified by:
			canBeUsed in class Item
		 * Returns:
		 * true if ntimes > 0
		 ------------------------------------------------------------------------------------------------------------------------*/
		public boolean canBeUsed() { 
			if(ntimes > 0) return true;
			else {
				System.out.println("The " + this.getId() + " " + Constants.MESSAGE_EMPTY);
				return false;
			}
		}
		
		/*-----------------------------------------------------------------------------------------------------------------------
		 * Method that prints an Item. The pattern is: --item[<>]=<>//<>
		 * Overrides:
			toString in class Item
		 ------------------------------------------------------------------------------------------------------------------------*/
		public String toString(){
					return super.toString()+"//"+this.ntimes;
		}
			

}
