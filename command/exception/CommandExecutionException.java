package tp.pr4.command.exception;

public class CommandExecutionException extends Exception {
	
	public CommandExecutionException(){}
	
	public CommandExecutionException(String a) {
		super(a);
	
	}
	
	public CommandExecutionException(String a, Throwable arg1) {
		super(a);
	
	}
	
	public CommandExecutionException(Throwable arg0) {}



}
