package tp.pr4;

public class Constants {
	public Constants(){
	}
	
	public static final String LINE_SEPARATOR = System.getProperty("line.separator");
	public static final String WORD_SEPARATOR = System.getProperty("word.separator");

	//Used in ExpirationItem class. It defines the default value of the live of this kind of Items.
	public static final int DEFAULT_EXPIRATION_LIVE=10;
	
	//Used in Game class. It indicates the end of the game.
	public static final String MESSAGE_FIN="GAME OVER " + Constants.LINE_SEPARATOR +" Thank you for playing, goodbye.";
	
	//Used in Game class. It is used when an object is not in the room and an user tries to pick it.
	public static final String MESSAGE_PICK_ERROR="Do you get to pick what you dream about?";
	
	//Used in Game class. It is used when a player dies.
	public static final String MESSAGE_DIE="You are dead, and there aren«t zombies in this game (yet).";
	
	//Used in Game class. Is is used when a player tries to pick an object, but it is contained in its inventory. To use it you should MESSAGE_ITEM_IS_IN_INVENTARY.replace("{id}", your_id)
	public static final String MESSAGE_ITEM_IS_IN_INVENTARY="You have another item in your inventory.";
	
	//Used in Game class. This message is shown when you try to use an object but it is not in your inventory.
	public static final String MESSAGE_TRY_USE_ITEM_BUT_NOT_EXISTS="Someone stole your ";
	
	//Used in Game class. This message is shown when an Item changes something (open a door, change your live...).
	public static final String MESSAGE_CHANGES="Something changes ...";
	
	//Used in Game class. This message is shown when an Item can not be performed.
	public static final java.lang.String MESSAGE_CHANGES_ERROR="I did not go to TP classes last week, I do not know how to use it...";
	
	//Used in Game class. This message is shown when the player changes the room
	public static final String MESSAGE_CHANGE_ROOM="...moving to ";
	
	//Used in Game class. This message is shown when there is a door, it is closed and the player tries to go in this direction.
	public static final String MESSAGE_DOOR="There is a door in the ";
	
	//Used in Game class. Promt.
	public static final String PROMT="> ";
	
	//Used in Game class. This message is shown when the user tries to look an item <> but she hasn't it in the inventory.
	public static final String MESSAGE_NO_ITEM="Someone stole your ";
	
	//Used in Game class. When the command is unknown this messaged is showed.
	public static final String MESSAGE_WHAT="What?";
	
	//Used in Game class. When the user tries to go to a direction, but there is a wall.
	public static final String MESSAGE_WALL="What the hell am I supposed to do going to ";
	
	//Used in Game class. When there is a door in a way but it is unidirectional and you can't come back
	public static final String MESSAGE_UNI_DOOR = "Impossible to go through the door from this side.";
	
	//Used in Game class. When an item is empty then it is showed this message.
	public static final String MESSAGE_EMPTY=/*" The "+Constants.WORD_SEPARATOR+ "*/ "is empty. It is deleted from the inventory.";
	
	//Used in Player class. Initial value of the live.
	public static final int INITIAL_LIVE=100;
	
	//Used in Player class. Initial value of the score of a player.
	public static final int INITIAL_SCORE=0;
	
	//Used in Player class. If there are no items, then the player shows this message.
	public static final String MESSAGE_POOR="You are poor, you have not got any item (yet).";
	
	//Used in player class. This value represents the amount of health that the player looses when she changes the room.
	public static final int LOST_LIVE=5;
	
	//Used in player class. Message showed when the player lists her items.
	public static final String MESSAGE_ITEMS="My items are:";
	
	//Used in player class. They are parsed both the health value and the score value.
	public static final String MESSAGE_PLAYER_TOSTRING_HEALTH = "HEALTH = ";
	
	public static final String MESSAGE_PLAYER_TOSTRING_SCORE = " SCORE =";

	public static final java.lang.String MESSAGE_ITEMS_ROOM="It contains the following items:";
	//Used in Room class. Message showed when the player lists her items.
	
	//Used in Room class. When a room hasn't any item then this message is shown.
	public static final String MESSAGE_NO_ITEMS="This room is empty";

	
	public static final String MESSAGE_HELP="You are lost. You are alone. You wander around" 
			+ Constants.LINE_SEPARATOR + "Your command words are:" + Constants.LINE_SEPARATOR 
			+ "   EXAMINE|EXAMINAR" + Constants.LINE_SEPARATOR 
			+ "   GO|IR { NORTH|EAST|SOUTH|WEST }"+Constants.LINE_SEPARATOR
			+ "   HELP|AYUDA"+Constants.LINE_SEPARATOR
			+ "   LOOK|MIRA [<<id>>]"+ Constants.LINE_SEPARATOR 
			+ "   PICK|COGER <<id>>"+Constants.LINE_SEPARATOR 
			+ "   DROP|SOLTAR <<id>>"+Constants.LINE_SEPARATOR 
			+ "   QUIT|SALIR"+Constants.LINE_SEPARATOR
			+ "   USE|USAR <<id>>"+Constants.LINE_SEPARATOR ;
}
