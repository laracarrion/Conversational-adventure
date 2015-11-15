package tp.pr4.commands;

import tp.pr4.Game;
import tp.pr4.command.exception.CommandExecutionException;
import tp.pr4.command.exception.WrongCommandFormatException;

public interface Command {
	public abstract Command parse (String cad, Game execContext) throws  WrongCommandFormatException;
	
	public abstract void execute() throws CommandExecutionException;
	
	public abstract String getHelp();
}
