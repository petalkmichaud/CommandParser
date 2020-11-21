package cs350f20project.controller.cli.parser;

import cs350f20project.controller.command.A_Command;
import cs350f20project.controller.command.meta.CommandMetaDoExit;

public class CommandParser 
{
	private String commandText;
	private MyParserHelper parserHelper;
	
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
	}
}
