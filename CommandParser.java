package cs350f20project.controller.cli.parser;
import java.awt.List;
import java.util.Arrays;
import java.util.LinkedList;

import cs350f20project.controller.cli.TrackLocator;
import cs350f20project.controller.command.A_Command;
import cs350f20project.controller.command.behavioral.CommandBehavioralBrake;//keep 
import cs350f20project.controller.command.behavioral.CommandBehavioralSelectBridge;
import cs350f20project.controller.command.behavioral.CommandBehavioralSelectRoundhouse;
import cs350f20project.controller.command.behavioral.CommandBehavioralSetDirection;
import cs350f20project.controller.command.behavioral.CommandBehavioralSetReference;
import cs350f20project.controller.command.behavioral.CommandBehavioralSelectSwitch;//keep
import cs350f20project.controller.command.creational.CommandBehaviouralSetSpeed;//keep
import cs350f20project.controller.command.meta.CommandMetaDoExit;//keep
import cs350f20project.controller.command.structural.CommandStructuralCommit;



public class CommandParser {
	
	private String commandText;
	private MyParserHelper parserHelper; 
	public static String id;
	private String id1;
	private String idn;
	private String id2;
	private String position; 
	private boolean isUp, isDown, isClockwise, isCounterClockwise;
	private Angle angle;
	
	
	private String[] command2 = ("DO BRAKE " + id).split(" ");
	private String[] command6Up = ("DO SELECT DRAWBRIDGE " + id + " POSITION UP").split(" ");
	private String[] command6Down = ("DO SELECT DRAWBRIDGE " + id + " POSITION DOWN").split(" ");
	private String[] command7Clockwise = ("DO SELECT ROUNDHOUSE " + id + " POSITION " + angle + " CLOCKWISE").split(" ");
	private String[] command7CounterClockwise = ("DO SELECT ROUNDHOUSE " + id + " POSITION " + angle + " COUNTERCLOCKWISE").split(" ");
	private String[] command8Primary = ("DO SELECT SWITCH " + id + " PATH PRIMARY").split(" ");
	private String[] command8Secondary = ("DO SELECT SWITCH " + id + " PATH SECONDARY").split(" ");
	private String[] command11Forward =("DO SET id DIRECTION " + id + " FORWARD").split(" ");
	private String[] command11Backward =("DO SET id DIRECTION " + id + " BACKWARD").split(" ");
	private String [] command12 =("DO SET REFERENCE ENGINE " + id).split(" ");
	private String[] command15 = ("DO SET id SPEED number" + id).split(" ");

	public CommandParser(MyParserHelper parserHelper, String commandText) {
		this.commandText = commandText;
		this.parserHelper= parserHelper; 
	}
	
	public void parse() {
		// command 51 - DONE 
		if (this.commandText.equalsIgnoreCase("@exit"))
		{
			A_Command command = new CommandMetaDoExit();
			this.parserHelper.getActionProcessor().schedule(command);
		}
	
		//command 2 - DONE
		else if (this.commandText.equalsIgnoreCase(command2))
		{
			A_Command command = new CommandBehavioralBrake(id);
			this.parserHelper.getActionProcessor().schedule(command);
		}
		//command 6 UP - DONE
		else if(this.commandText.equalsIgnoreCase(command6Up)) {
			
			A_Command command = new CommandBehavioralSelectBridge(position, isUp);
			this.parserHelper.getActionProcessor().schedule(command);
			
		}
		//command 6 DOWN - DONE
		else if(this.commandText.equalsIgnoreCase(command6Down)) {
			
			A_Command command = new CommandBehavioralSelectBridge(position, isDown);
			this.parserHelper.getActionProcessor().schedule(command);
			
		}
		//command 7 clockwise-DONE
		else if(this.commandText.equalsIgnoreCase(command7Clockwise)){
			
			A_Command command = new CommandBehavioralSelectRoundhouse(commandText, angle, isClockwise);
			this.parserHelper.getActionProcessor().schedule(command);
		}
		//command 7 Counterclockwise -DONE 
		else if(this.commandText.equalsIgnoreCase(command7CounterClockwise)){
			
			A_Command command = new CommandBehavioralSelectRoundhouse(commandText, angle, isCounterClockwise);
			this.parserHelper.getActionProcessor().schedule(command);
		}
		//command 8 primary -DONE
		else if (this.commandText.equalsIgnoreCase(command8Primary))
		{
			A_Command command = new CommandBehavioralSelectSwitch(commandText, false);
			this.parserHelper.getActionProcessor().schedule(command);
		}
		//command 8 secondary -DONE
		else if (this.commandText.equalsIgnoreCase(command8Secondary))
		{
			A_Command command = new CommandBehavioralSelectSwitch(commandText, false);
			this.parserHelper.getActionProcessor().schedule(command);
		}
		
		//command 11 Forward -DONE
		
		else if(this.commandText.equalsIgnoreCase(command11Forward)){
			
			A_Command command = new  CommandBehavioralSetDirection(commandText,false);	
			this.parserHelper.getActionProcessor().schedule(command);
		
		}
		//command11 Backward -DONE 
		else if(this.commandText.equalsIgnoreCase(command11Backward)){
			
			A_Command command = new  CommandBehavioralSetDirection(commandText,false);	
			this.parserHelper.getActionProcessor().schedule(command);
		}
		
		//command 12-DONE 
		else if(this.commandText.equalsIgnoreCase(command12)){
		
			A_Command command = new  CommandBehavioralSetReference(commandText);
			this.parserHelper.getActionProcessor().schedule(command);
		}
		
		//command 15-DONE
		else if(this.commandText.equalsIgnoreCase(command15)){
			
			A_Command command - new CommandBehavioralSetSpeed(commandText);
			this.parserHelper.getActionProcessor().schedule(command);
		}
	
		//command 55
		else if(this.commandText.equalsIgnoreCase("CLOSE view id")) {
			
			A_Command command = new CommandMetaViewDestroy(id); 
			this.parserHelper.getActionProcessor().schedule(command));
		}
		
		//command 60
		else if(this.commandText.equals("COMMIT")) {
	    	A_Command command=new CommandStructuralCommit(commandText);
	    	this.parserHelper.getActionProcessor().schedule(command);
	    }
	    
	}
		
}

