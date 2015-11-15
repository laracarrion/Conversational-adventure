package tp.pr4.command.exception;

public class WrongCommandFormatException extends Exception {
	

public WrongCommandFormatException() {}

	
	public WrongCommandFormatException(String a){
		super(a);
	}

	
	public WrongCommandFormatException(String a, Throwable arg1){
		super(a);
	}

	
	public WrongCommandFormatException(Throwable arg0) {}



}
