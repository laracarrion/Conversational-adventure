package tp.pr4.commands;

import tp.pr4.*;
import tp.pr4.command.exception.*;

public class UseCommand implements Command{
	private Player player;
	private Room current;
	private String item;
	
	public UseCommand(){
		this.player = null;
		this.current = null;
		this.item = "";
	}
	
	private UseCommand(Player p, Room r, String it){
		this.current = r;
		this.item = it;
		this.player = p;
	}
	
	public Command parse(String cad, Game execContext) throws WrongCommandFormatException {
		String[] words = cad.split(" ");
		if ((words.length == 2)
			&& (words[0].equalsIgnoreCase("USE") || words[0].equalsIgnoreCase("USAR"))
				&& (words[1]!=null)){ 
						return new UseCommand(execContext.getPlayer(), execContext.getCurrentMap().getCurrentRoom(), (String)words[1]);
				}throw new WrongCommandFormatException(Constants.MESSAGE_WHAT);
	}

	public String getIdItem(){
		return this.item;
	}
	
	public String getHelp(){
		return "USE|USAR<>";
	}
	
	public void execute() throws CommandExecutionException{
		
			if(!(this.player.hayItem(this.getIdItem()))) throw new CommandExecutionException(Constants.MESSAGE_TRY_USE_ITEM_BUT_NOT_EXISTS + this.item);
			else{
			if (this.getIdItem()!=null && this.getIdItem()!=""){ 			
					int pos = this.player.getPosicionItem(this.getIdItem()); 
					this.player.itemByPosition(pos).use(player, current); 	
					if (!(this.player.itemByPosition(pos).canBeUsed())){ 
						this.player.removeByPosition(pos);
					}
				}

			}


	}
}
