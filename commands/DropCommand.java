package tp.pr4.commands;

import tp.pr4.*;
import tp.pr4.command.exception.*;
import tp.pr4.items.Item;

public class DropCommand implements Command{
	private String itemToDrop; 
	private Player player;
	private Room current;	
	
	public DropCommand(){
		this.itemToDrop = "";
		this.player = null;
		this.current = null;
		
	}
	
	private DropCommand(Player p, Room c, String s) {
		this.itemToDrop = s;
		this.player = p;
		this.current =c;
	}
	
	@Override
	public Command parse(String cad, Game execContext) throws WrongCommandFormatException {
		String[] words = cad.split(" ");
		if ((words.length == 2) //si hay algo más que leer
			&& (words[0].equalsIgnoreCase("DROP") || words[0].equalsIgnoreCase("SOLTAR"))
				&& (!(words[1].equalsIgnoreCase(""))) && (words[1]!=null)) 
					{return new DropCommand(execContext.getPlayer(), execContext.getCurrentMap().getCurrentRoom(), words[1]);};
				throw new WrongCommandFormatException(Constants.MESSAGE_WHAT);	
	}
	
	public void execute() throws CommandExecutionException{ 
	
	if(this.getIdItem()!=""/* && this.getIdItem()!=null*/) {
		
		if(!(this.player.hayItem(this.getIdItem())))
			throw new CommandExecutionException("You do not have any " + this.itemToDrop.toString() + ".");
		
		if(this.current.existsItem(this.getIdItem())) {
			throw new CommandExecutionException("Ese item ya existe");
		}
		
		else{
				int pos = this.player.getPosicionItem(this.getIdItem());
				Item it=this.player.getItem(this.getIdItem());
				this.player.removeByPosition(pos); 
				this.current.addItem(it); 
		
			
		}
		
	}
}

	public String getIdItem(){
		return this.itemToDrop;
	}
	
	public String getHelp(){
		return "DROP | SOLTAR <>";
	}

}
