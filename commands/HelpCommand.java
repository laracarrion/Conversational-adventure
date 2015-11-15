package tp.pr4.commands;

import tp.pr4.*;
import tp.pr4.command.exception.*;

public class HelpCommand implements Command{
	private String help;
	
	public HelpCommand(){
		this.help = "";
	}
	
	private HelpCommand(String s){
		this.help=s;
	}
	public Command parse(String cad, Game execContext) throws WrongCommandFormatException {
		String[] words = cad.split(" ");
		if (words.length == 1){
			if ((words[0].equalsIgnoreCase("HELP"))||(words[0].equalsIgnoreCase("AYUDA"))){
				try{
					return new HelpCommand (words[0]);
				}
				catch (Exception e){throw new WrongCommandFormatException(Constants.MESSAGE_WHAT);}
			}
			else throw new WrongCommandFormatException(Constants.MESSAGE_WHAT);
		}
		else throw new WrongCommandFormatException(Constants.MESSAGE_WHAT);
	}
	
	public String getHelp(){
		return "HELP|AYUDA";
	}
	
	public void execute() throws CommandExecutionException{
		try{
			System.out.println(Parser.getHelp());
		}catch (Exception e) {throw new CommandExecutionException();}
	}
}
