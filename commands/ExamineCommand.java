package tp.pr4.commands;

import tp.pr4.*;
import tp.pr4.command.exception.*;

public class ExamineCommand implements Command{
private Room current;
	
	public ExamineCommand(){
		this.current = null;
	}
	
	private ExamineCommand(Room c){ 
		//this.ex=s;
		this.current=c;
	}
	@Override
	public Command parse(String cad, Game execContext) throws WrongCommandFormatException {
		String[] words = cad.split(" ");
		if (words.length==1){
			if ((words[0].equalsIgnoreCase("EXAMINE"))||(words[0].equalsIgnoreCase("EXAMINAR"))){
				try{
					return new ExamineCommand(execContext.getCurrentMap().getCurrentRoom());
				}
				catch(Exception e){throw new WrongCommandFormatException(Constants.MESSAGE_WHAT);}
			}
			else throw new WrongCommandFormatException(Constants.MESSAGE_WHAT);
		}
		else throw new WrongCommandFormatException(Constants.MESSAGE_WHAT);
	}
	
	
	public void execute() throws CommandExecutionException{
		try{
			if(this.current!=null){
				System.out.println(this.current.getDescription());
			}
		} catch (Exception e){throw new CommandExecutionException();}
	}
	
	public String getHelp(){
		return "EXAMINE|EXAMINAR";
	}
}
