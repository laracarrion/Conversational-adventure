package tp.pr4;

public class Door {
	private Room source;
	private Room target;
	private boolean bid;
	

	private boolean closed;
	private Directions dir;

//==================================================Constructoras=================================================
	public Door (Room source, Directions direction, Room target, boolean bidirectional){
		this.source = source;
		this.target = target;
		this.bid = bidirectional;
		this.closed = true;//cerrada por defecto
		this.dir = direction;
	}
	
	public Door (Room source, Directions direction, Room target, boolean bidirectional, boolean isOpen){
		this.source = source;
		this.target = target;
		this.bid = bidirectional;
		this.closed = isOpen;
		this.dir = direction;
	}
//=======================================================Metodos==================================================

	/*------------------------------------------------------------------------------------------------------------
	 * Returns the source of the door
	 ------------------------------------------------------------------------------------------------------------*/
	public Room getSource() {
		return this.source;
		
	}
	/*------------------------------------------------------------------------------------------------------------
	 * Returns the target of the door
	 ------------------------------------------------------------------------------------------------------------*/
	public Room getTarget() {
		return this.target;
	}
	/*------------------------------------------------------------------------------------------------------------
	 * Checks if the door is bidirectional
	 * Returns:
	 	true if the door is bidirectional
	 	false otherwise
	 ------------------------------------------------------------------------------------------------------------*/
	public boolean isBid() {
		return this.bid;
	}
	/*------------------------------------------------------------------------------------------------------------
	 * Sets the direction of a door
	 ------------------------------------------------------------------------------------------------------------*/
	public void setDir(Directions dir) {
		this.dir = dir;
	}
	
	/*------------------------------------------------------------------------------------------------------------
	 * This function opens a door.
	 ------------------------------------------------------------------------------------------------------------*/
	public void open(){
		this.closed=false;
	}
	
	/*------------------------------------------------------------------------------------------------------------
	 * This function closes a door.
	 ------------------------------------------------------------------------------------------------------------*/
	public void close(){
		this.closed=true;
	}
	
	/*------------------------------------------------------------------------------------------------------------
	 * Returns the room of the other side from whereAmI if it is possible (even if the door is closed).
	 * Parameters:whereAmI - Room. 
	 * Returns:
	 	Returns the other room if the door is at whereAmI and the room may act as the source of the movement. 
	 	It returns null otherwise.
	 ------------------------------------------------------------------------------------------------------------*/
	public Room nextRoom(Room whereAmI){
			if (this.source==whereAmI)
				return this.target;
			else
				if (this.target == whereAmI && this.bid) return this.source;
			
			return null;
		}
	/*-----------------------------------------------------------------------------------------------------------
	 * Returns true if this door links roomA and roomB and we can go from roomA to roomB. 
	 * Let us note that the door might be close.
	 -----------------------------------------------------------------------------------------------------------*/
	public boolean connect(Room room1, Room room2){
		if ((this.source==room1) && (this.target==room2))
			return this.isOpen();
		
		if (this.isBid()){
			if (((this.source==room1) && (this.target==room2))
					||((this.source==room2) && (this.target==room1)))
				if (this.isOpen()) return true;
		}
		return false;		
	}

	/*-----------------------------------------------------------------------------------------------------------
	 * Checks if a door is open
	 * Returns:
	 	true if the door is open
	 	false otherwise
	 -----------------------------------------------------------------------------------------------------------*/
	public boolean isOpen(){
		return !(this.closed);
	}
	
	
	/*-----------------------------------------------------------------------------------------------------------
	 * Checks if the door is in a room
 	 * Parameters:room - The room to check 
 	 * Returns:
 	 	true if the door belongs to the input Room room . 
 	 * Let us note that if the door is bidirectional then it checks that room == source || room == target.
	 -----------------------------------------------------------------------------------------------------------*/
	public boolean isInRoom(Room room){
		if (this.isBid()) return ((this.source==room)||(this.target==room));
		return (this.source==room);
	}
	
	/*-----------------------------------------------------------------------------------------------------------
	 * Returns true if the input parameter door belongs to this room at the direction represented in where.
 	 * Parameters:
 	  	room - The room to check
 	  	where - Direction used. 
 	 * Returns:
 	 	true if the door belongs to the input Room room .
	 -----------------------------------------------------------------------------------------------------------*/
	public boolean isInRoom (Room room, Directions where){
		return (((this.source==room)&& (this.dir==where))||((this.target==room) && (this.dir==where.getOposite())));
	}
}
