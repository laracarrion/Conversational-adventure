package tp.pr4;

import java.util.Scanner;

import tp.pr4.command.exception.*;
import tp.pr4.commands.*;

public class Game {
	private Room current;
	private Player player;
	private Map mapa;
	
	//====================================Constructora==============================================
	
	public Game(Map map){
		if(map!=null) this.current=map.getCurrentRoom();
		player = new Player();
		mapa = map;	
	}
	
	/**
	 * Access to the player
	 * @return the player
	 */
	
	public Player getPlayer(){
		return this.player;
	}
	
	/**
	 * Access to the map
	 * @return the map
	 */
	
	public Directions getDir(String s) {

		if (s.equalsIgnoreCase(Directions.EAST.name())) return Directions.EAST;
		if (s.equalsIgnoreCase(Directions.NORTH.name())) return Directions.NORTH;
		if (s.equalsIgnoreCase(Directions.WEST.name())) return Directions.WEST;
		if (s.equalsIgnoreCase(Directions.SOUTH.name())) return Directions.SOUTH;
		return null;
	}
	public Map getCurrentMap(){
		return this.mapa;
	}
	
	public void requestQuit(){
	
	}
	
	/*
	 * Prints information about the current room
	 */
	public void showCurrentRoom(){
		System.out.println(this.current.getDescription());
	}
	
	/*
	 * Prints information when the game is finished
	 */
	public void showGameOver(){
		System.out.println(Constants.MESSAGE_FIN);
	}
	
	public void runGame() {
		
		boolean terminado = false;
		
		if(this.mapa != null){
			System.out.println(current.getDescription());
			System.out.println(Constants.MESSAGE_PLAYER_TOSTRING_HEALTH + Constants.INITIAL_LIVE + ","+
				Constants.MESSAGE_PLAYER_TOSTRING_SCORE+ Constants.INITIAL_SCORE);
			terminado = false;
			
		}
		else terminado = true;
		Scanner sc = new Scanner(System.in);
		String i;
		while (! terminado){
			System.out.print(Constants.PROMT);
			i = sc.nextLine();
			
			try {
				Command c  = Parser.parseCommand(i, this); 
	            c.execute();
			}
			
			catch (WrongCommandFormatException e) {
				System.out.println(e.getMessage());
			}
			
			catch (CommandExecutionException e) {
				System.out.println(e.getMessage());
			}
			
			finally{
				if ((this.player.dead()) || (this.mapa.getCurrentRoom().isExit()) ||i.equalsIgnoreCase("Quit") ||i.equalsIgnoreCase("Salir")){
					terminado = true;
					System.out.println(Constants.MESSAGE_FIN);
					System.out.println(Constants.MESSAGE_PLAYER_TOSTRING_HEALTH + this.getPlayer().getHealth() + ","+
							Constants.MESSAGE_PLAYER_TOSTRING_SCORE+ this.getPlayer().getPoints());
				}
			
			}
		}
		
	}
}
