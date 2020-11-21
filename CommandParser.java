package cs350f20project.controller.cli.parser;



import cs350f20project.controller.command.A_Command;
import cs350f20project.controller.command.behavioral.CommandBehavioralBrake;
import cs350f20project.controller.command.meta.CommandMetaDoExit;
import cs350f20project.datatype.Angle;
import cs350f20project.datatype.CoordinatesDelta;
import cs350f20project.datatype.CoordinatesWorld;
import cs350f20project.datatype.Latitude;
import cs350f20project.datatype.Longitude;

public class CommandParser {
 
  
  private Angle angle;
  private CoordinatesDelta coordinates_delta;
  private CoordinatesWorld coordinates_world;
  private String id;
  private int integer;
  private Latitude latitude;
  private String string;
  private Longitude longitude;
  private double number;
  private double real;
  private String commandText;
  private MyParserHelper parserHelper;
  private CommandParserTokenManager tm;
  
	public CommandParser(MyParserHelper parserHelper, String commandText){
		this.parserHelper=parserHelper;
		this.commandText=commandText;
	}
	public CommandParser(CommandParserTokenManager tm) {
		this.tm=tm;
	}
	public void parse() {
		if(this.commandText.equals("DO BRAKE id")) {
			A_Command command=new CommandBehavioralBrake(id);
			this.parserHelper.getActionProcessor().schedule(command);

		}
	}
	
}
