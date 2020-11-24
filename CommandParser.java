package cs350f20project.controller.cli.parser;

import cs350f20project.controller.command.A_Command;
import cs350f20project.controller.command.behavioral.CommandBehavioralBrake;
import cs350f20project.controller.command.behavioral.CommandBehavioralSelectBridge;
import cs350f20project.controller.command.behavioral.CommandBehavioralSelectRoundhouse;
import cs350f20project.controller.command.behavioral.CommandBehavioralSelectSwitch;
import cs350f20project.controller.command.meta.CommandMetaDoExit;

public class CommandParser 
{
	private String commandText;
	private MyParserHelper parserHelper;
	private String id;
	private String position;
	
	public CommandParser(MyParserHelper parserHelper, String commandText)
	{
		this.commandText = commandText;
		this.parserHelper = parserHelper;
	}
	
	
	public void parse()
	{
		if (this.commandText.equalsIgnoreCase("@exit"))
		{
			A_Command command = new CommandMetaDoExit();
			this.parserHelper.getActionProcessor().schedule(command);
		}
	
		//COMMAND 2
		else if (this.commandText.equalsIgnoreCase("DO BRAKE id"))
		{
			A_Command command = new CommandBehavioralBrake(id);//id should be the last part of the commandText string
			this.parserHelper.getActionProcessor().schedule(command);
		}
		
		//COMMAND 6
		else if (this.commandText.equalsIgnoreCase("DO SELECT DRAWBRIDGE id POSITION (UP | DOWN)"))
		{
			A_Command command = new CommandBehavioralSelectBridge(position, true);//position should be either up or down(whichever is provided in commandText)
			this.parserHelper.getActionProcessor().schedule(command);			  //boolean is isUpElseDown
		}
		
		//COMMAND 7
		else if (this.commandText.equalsIgnoreCase("DO SELECT ROUNDHOUSE id POSITION angle ( CLOCKWISE | COUNTERCLOCKWISE )"))
		{
			A_Command command = new CommandBehavioralSelectRoundhouse(commandText, null, false);// string is the id of the roundhouse, angle is which angle in degrees it will turn
			this.parserHelper.getActionProcessor().schedule(command);							//boolean will be isClockwise
		}
		
		//COMMAND 8
		else if (this.commandText.equalsIgnoreCase("DO SELECT SWITCH id PATH ( PRIMARY | SECONDARY )"))
		{
			A_Command command = new CommandBehavioralSelectSwitch(commandText, false);// the id of the path and the boolean should be isPrimaryElseSecondary
			this.parserHelper.getActionProcessor().schedule(command);
		}
		
		
	}
}
