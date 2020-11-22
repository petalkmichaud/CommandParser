package cs350f20project.controller.cli.parser;



import java.util.Arrays;

import cs350f20project.controller.command.A_Command;
import cs350f20project.controller.command.PointLocator;
import cs350f20project.controller.command.behavioral.CommandBehavioralBrake;
import cs350f20project.controller.command.creational.CommandCreateTrackEnd;
import cs350f20project.controller.command.meta.CommandMetaDoExit;
import cs350f20project.controller.command.structural.CommandStructuralCommit;
import cs350f20project.datatype.Angle;
import cs350f20project.datatype.CoordinatesDelta;
import cs350f20project.datatype.CoordinatesWorld;
import cs350f20project.datatype.Latitude;
import cs350f20project.datatype.Longitude;

public class CommandParser {
 
  
  private Angle angle;
  private CoordinatesDelta coordinates_delta;
  
  public static String id="zzz";
  private int integer;
  private Latitude latitude=new Latitude(1);
  private String string;
  private Longitude longitude=new Longitude(1);
  private CoordinatesDelta coordinates_delta1=new CoordinatesDelta(1,1);
  private CoordinatesDelta coordinates_delta2=new CoordinatesDelta(1,1);
  private CoordinatesWorld coordinates_world=new CoordinatesWorld(latitude, longitude);
  private double number;
  private double real;
  private String commandText;
  private MyParserHelper parserHelper;
  private CommandParserTokenManager tm;
  private PointLocator locater=new PointLocator(coordinates_world, coordinates_delta1, coordinates_delta2);
  
	public CommandParser(MyParserHelper parserHelper, String commandText){
		this.parserHelper=parserHelper;
		this.commandText=commandText;
	}
	public CommandParser(CommandParserTokenManager tm) {
		this.tm=tm;
	}
	public void parse() {
	String[] x=("Do Break "+id).split(" ");         
	 String[] command44=("CREATE TRACK "+id+"REFERENCE "+coordinates_world+"DELTA START "+coordinates_delta1+"END "+coordinates_delta2).split(" ");
	    String[] command442=("CREATE TRACK "+id+"REFERENCE "+id+"DELTA START "+coordinates_delta1+"END "+coordinates_delta2).split(" ");
	    if(this.commandText.equals("COMMIT")) {
	    	A_Command command=new CommandStructuralCommit();
	    	this.parserHelper.getActionProcessor().schedule(command);
	    }
	    
	    else if(this.commandText.equalsIgnoreCase(Arrays.toString(x))) {
			System.out.println(Arrays.toString(x));
			A_Command command=new CommandBehavioralBrake(x[2]);
			this.parserHelper.getActionProcessor().schedule(command);

		}
	   
	    else if(this.commandText.equalsIgnoreCase(Arrays.toString(command44)) || this.commandText.equalsIgnoreCase(Arrays.toString(command442))) {              //44
	    	//
	    	A_Command command=new CommandCreateTrackEnd(id, locater);
	    	this.parserHelper.getActionProcessor().schedule(command);
	    	//System.out.println(Arrays.toString(command44));
	    }
	}
	public String getID() {
		return this.id;
	}
	public CoordinatesDelta getStartCoordinates() {
		return this.coordinates_delta1;
	}
	public CoordinatesDelta getEndCoordinates() {
		return this.coordinates_delta2;
	}
	public CoordinatesWorld getWorldCoordinates() {
		return this.coordinates_world;
	}
}

