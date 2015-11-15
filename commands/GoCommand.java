package tp.pr4.commands;

import tp.pr4.*;
import tp.pr4.command.exception.*;

public class GoCommand implements Command{
	private Directions dir;
	private Room current;
	private Map mapa;
	private Game game;
	
	public GoCommand(){
		this.dir = Directions.UNKNOWN;
		this.current = null;
		this.mapa = null;
		this.game = null;
	}
	
	private GoCommand(Directions d, Room r, Map m, Game g){
		this.dir=d;
		this.current=r;
		this.mapa=m;
		this.game = g;
	}
	
	public Command parse(String cad, Game execContext) throws WrongCommandFormatException {
		String[]words = cad.split(" ");

		if ((words.length==2) && ((words[0].equalsIgnoreCase("GO")))||(words[0].equalsIgnoreCase("IR"))){
			if (((words[1].equalsIgnoreCase("NORTH")) ||(words[1].equalsIgnoreCase("SOUTH"))
				||(words[1].equalsIgnoreCase("EAST"))||(words[1].equalsIgnoreCase("WEST")))){
					return new GoCommand(execContext.getDir(words[1]), execContext.getCurrentMap().getCurrentRoom(), execContext.getCurrentMap(), execContext);
			}
			else throw new WrongCommandFormatException(Constants.MESSAGE_WHAT);
		}
		throw new WrongCommandFormatException(Constants.MESSAGE_WHAT);
				
		
	
	}
	
	
	public String getHelp(){
		return "GO | IR";
	}
	
	public Directions getDirection() {
		return this.dir;
	}
	
	public void execute() throws CommandExecutionException{
		
			if(this.mapa.getDoor(this.current, getDirection())==null) throw new CommandExecutionException(Constants.MESSAGE_WALL + this.dir + "?");
			else{
			 if (!this.current.isExit()){
				if (this.mapa.getDoor(this.current, getDirection()).nextRoom(this.current)!=null){
					
					if(this.mapa.getDoor(this.current, getDirection()).isOpen()){
						if(!(this.mapa.getDoor(this.current, getDirection()).nextRoom(this.current).isExit())){
						
						
						  this.current = this.mapa.getDoor(this.current, getDirection()).nextRoom(this.current);
						  this.game.getPlayer().addHealth(-5);
						  System.out.println(Constants.MESSAGE_CHANGE_ROOM + this.dir);
						  System.out.println(this.current.getDescription());
						  System.out.println(Constants.MESSAGE_PLAYER_TOSTRING_HEALTH + this.game.getPlayer().getHealth() + ","+
							 Constants.MESSAGE_PLAYER_TOSTRING_SCORE+ this.game.getPlayer().getPoints());
						  this.mapa.setCurrentRoom(this.current);
						
						
						
					}
						else{
							this.current = this.mapa.getDoor(this.current, getDirection()).nextRoom(this.current);
							  this.game.getPlayer().addHealth(-5);
							  System.out.println(Constants.MESSAGE_CHANGE_ROOM + this.dir);
									  this.mapa.setCurrentRoom(this.current);
									  this.game.requestQuit();
						}
					}
					else throw new CommandExecutionException(Constants.MESSAGE_DOOR + this.dir + ", but it is closed.");
				
				}
				else throw new CommandExecutionException(Constants.MESSAGE_UNI_DOOR);
			 }
			}
		
		
		}
}
