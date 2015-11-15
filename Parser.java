package tp.pr4;

import tp.pr4.command.exception.WrongCommandFormatException;
import tp.pr4.commands.*;

public class Parser {
	public Parser(){
	}
	
	public static Command parseCommand(String line, Game executionContext) throws WrongCommandFormatException{

		Command [] comandos = new Command[8];
		
		comandos[0] = new LookCommand(); 
		comandos[1] = new DropCommand();
		comandos[2] = new GoCommand();
		comandos[3] = new HelpCommand();
		comandos[4] = new PickCommand(); 
		comandos[5] = new ExamineCommand();
		comandos[6] = new QuitCommand();
		comandos[7] = new UseCommand();
	
	
		for (int i=0;i<8; i++){
			try{
				 return comandos[i].parse(line, executionContext); 
				
			}
			
			catch(WrongCommandFormatException e){
				
			}
		}
	
		
		throw new WrongCommandFormatException(Constants.MESSAGE_WHAT);

		
	}
	
	public static String getHelp(){
		return Constants.MESSAGE_HELP;
	}
}
