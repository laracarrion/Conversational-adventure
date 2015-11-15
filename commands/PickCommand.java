package tp.pr4.commands;

import tp.pr4.*;
import tp.pr4.command.exception.*;

public class PickCommand implements Command{
	private String item;
	private Room current;
	private Player player;

	
	public PickCommand(){
		this.item = "";
		this.current = null;
		this.player = null;
	}
	
	/**
	 * It builds a command without the context of execution. 
	 * Therefore, if the command is executed an exception should be raised.
	 */
	private PickCommand(Room r, Player j, String it){
		this.item=it;
		this.current=r;
		this.player=j;
	}
	
	/**
	 * Parsers the String returning an instance of PickCommand or throwing a WrongCommandFormatException()
	 * @cad-text String to parse
	 * @execContext - Executing Game
	 * 
	 * Returns:
	 * 	    Command Reference to an instance of PickCommand
	 * Throws:
	 * 	    WrongCommandFormatException - When the String is not PICK <>
	 * @Override
	 */
	
	public Command parse(String cad, Game execContext) throws WrongCommandFormatException {
		String[] words = cad.split(" ");
		if ((words.length==2) 
				&& (words[0].equalsIgnoreCase("pick") || (words[0].equalsIgnoreCase("coger")))
				&&(!(words[1].equals("")))){
		return new PickCommand(execContext.getCurrentMap().getCurrentRoom(), execContext.getPlayer(), words[1]);}
						
	throw new WrongCommandFormatException(Constants.MESSAGE_WHAT);
			
	}
	
	public void execute() throws CommandExecutionException{
		
		if(this.getIdItem()!="" && this.getIdItem()!=null) {
			if(!(this.player.hayItem(this.getIdItem()))){ 
				if(this.current.existsItem(this.getIdItem())){
					this.current.pickItem(this.player, this.getIdItem());
				}
				else throw new CommandExecutionException(Constants.MESSAGE_PICK_ERROR);
			}
			
			else throw new CommandExecutionException(Constants.MESSAGE_ITEM_IS_IN_INVENTARY);
		}
	}
				
	public String getIdItem(){
		return this.item;
	}
	
	public String getHelp(){
		return "PICK|COGER <>";
	}
}
