package tp.pr4.commands;

import tp.pr4.*;
import tp.pr4.command.exception.*;

public class LookCommand implements Command{
	private String id; 
	private Player player; 
	
	public LookCommand(){
		this.id= "";
		this.player = null;
	}
	
	private LookCommand(Player pl, String s){
		this.player=pl;
		this.id=s;
	}
	
	public Command parse(String cad, Game execContext) throws WrongCommandFormatException {
		
		String[] words = cad.split(" ");
		
		if (words.length == 2){
			if ((words[0].equalsIgnoreCase("LOOK"))||(words[0].equalsIgnoreCase("MIRA"))){//si por lo menos empieza por look o mira
				if(words[1]!=null) {
				return new LookCommand(execContext.getPlayer(), words[1]);
				}
			}
		}
		
		else if ((words.length==1) && (words[0].equalsIgnoreCase("look") || words[0].equalsIgnoreCase("mira"))) //si es look solo
					return new LookCommand(execContext.getPlayer(),"");

							
			
		
     	throw new WrongCommandFormatException(Constants.MESSAGE_WHAT);
		
	}

	public String getHelp(){
		return "LOOK|MIRA <>";
	}
	
	public void execute() throws CommandExecutionException{
		if(this.id!="" && this.id!=null){
				if(this.player.hayItem(this.id)){
					int pos = this.player.getPosicionItem(this.id);
					System.out.println(this.player.itemByPosition(pos).toString());
				}
				else throw new CommandExecutionException("There is no " + this.id + " in your inventory.");
		}
			else System.out.println(this.player.showItems());
		
		
	}
}
