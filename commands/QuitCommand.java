package tp.pr4.commands;

import tp.pr4.*;
import tp.pr4.command.exception.*;

public class QuitCommand implements Command {
private Game game;
	
	public QuitCommand(){
		this.game = null;
	}
	
	private QuitCommand(Game g){
		this.game = g;
	}
	public Command parse(String cad, Game execContext) throws WrongCommandFormatException {
		String[] words =cad.split(" ");
		if ((words.length == 1) 
		&& ((words[0].equalsIgnoreCase("QUIT"))||(words[0].equalsIgnoreCase("SALIR")))){
				return new QuitCommand(execContext);
			}throw new WrongCommandFormatException(Constants.MESSAGE_WHAT);
	}

	public void execute () throws CommandExecutionException{
		try{
			this.game.requestQuit();
		}
		catch (Exception e){
			throw new CommandExecutionException();
	}
	}
	
	public String getHelp(){
		return "QUIT|SALIR";
	}
}
