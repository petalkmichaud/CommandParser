package cs350f20project.controller.cli.parser;



import java.util.Arrays;
import java.util.LinkedList;

import cs350f20project.controller.cli.TrackLocator;
import cs350f20project.controller.command.A_Command;
import cs350f20project.controller.command.PointLocator;
import cs350f20project.controller.command.behavioral.CommandBehavioralBrake;
import cs350f20project.controller.command.behavioral.CommandBehavioralSelectBridge;
import cs350f20project.controller.command.creational.CommandCreatePowerCatenary;
import cs350f20project.controller.command.creational.CommandCreatePowerPole;
import cs350f20project.controller.command.creational.CommandCreatePowerStation;
import cs350f20project.controller.command.creational.CommandCreateTrackCurve;
import cs350f20project.controller.command.creational.CommandCreateTrackEnd;
import cs350f20project.controller.command.meta.CommandMetaDoExit;
import cs350f20project.controller.command.structural.CommandStructuralCommit;
import cs350f20project.datatype.Angle;
import cs350f20project.datatype.CoordinatesDelta;
import cs350f20project.datatype.CoordinatesWorld;
import cs350f20project.datatype.Latitude;
import cs350f20project.datatype.Longitude;

public class CommandParser {
 
  private LinkedList<String> idSubstations=new LinkedList<>();
  private Angle angle;
  private CoordinatesDelta coordinates_delta;
  private CoordinatesDelta coordinates_delta3=new CoordinatesDelta(1,1);
  private String id1="sss";
  private String idn ="ssss";
  private String id2="zz";
  public static String id="zzz";
  private int integer;
  private Latitude latitude=new Latitude(1);
  private String string;
  private Longitude longitude=new Longitude(1);
  private CoordinatesDelta coordinates_delta1=new CoordinatesDelta(1,1);
  private CoordinatesDelta coordinates_delta2=new CoordinatesDelta(1,1);
  private CoordinatesWorld coordinates_world=new CoordinatesWorld(latitude, longitude);
  private double number=1;
  private double real;
  private TrackLocator START;
  private TrackLocator STOP;
  private String commandText;
  private MyParserHelper parserHelper;
  private CommandParserTokenManager tm;
  private PointLocator locater=new PointLocator(coordinates_world, coordinates_delta1, coordinates_delta2);
  private LinkedList<String> idpoles=new LinkedList();
  
	public CommandParser(MyParserHelper parserHelper, String commandText){
		this.parserHelper=parserHelper;
		this.commandText=commandText;
	}
	public CommandParser(CommandParserTokenManager tm) {
		this.tm=tm;
	}
	public void parse() {
    //need to go back and add $ 
	String[] x=("Do Break "+id).split(" ");        
	//#44
	 String[] command44=("CREATE TRACK "+id+"REFERENCE "+coordinates_world+"DELTA START "+coordinates_delta1+"END "+coordinates_delta2).split(" ");
	    String[] command442=("CREATE TRACK "+id+"REFERENCE "+id1+"DELTA START "+coordinates_delta1+"END "+coordinates_delta2).split(" ");      //#44
	//43    
	    String[] command43=("CREATE TRACK CURVE "+id+"REFERENCE "+coordinates_world+"DELTA START "+coordinates_delta1+"END"+coordinates_delta2+"DISTANCE ORIGIN "+number).split(" ");
	    String[] command432=("CREATE TRACK CURVE "+id+"REFERENCE "+id1+"DELTA START "+coordinates_delta1+"END"+coordinates_delta2+"DISTANCE ORIGIN "+number).split(" ");
	    String[] command433=("CREATE TRACK CURVE "+id+"REFERENCE "+coordinates_world+"DELTA START "+coordinates_delta1+"END"+coordinates_delta2+"DISTANCE ORIGIN "+coordinates_delta3).split(" ");
	    String[] command434=("CREATE TRACK CURVE "+id+"REFERENCE "+id1+"DELTA START "+coordinates_delta1+"END"+coordinates_delta2+"DISTANCE ORIGIN "+coordinates_delta3).split(" ");
	//6
	    String[] command6=("DO SELECT DRAWBRIDGE "+id+"POSITION UP").split(" ");
	    String[] command61=("DO SELECT DRAWBRIDGE "+id+"POSITION DOWN").split(" ");
	//22 
	    String[] command22=("CREATE POWER CATENARY "+id1+"WITH POLES "+idn+"+").split(" ");
	//23 
	    String[] command23=("CREATE POWER POLE "+id1+"ON TRACK "+id2+"DISTANCE "+number+"FROM "+"START").split(" ");
	    String[] command232=("CREATE POWER POLE "+id1+"ON TRACK "+id2+"DISTANCE "+number+"FROM "+"END").split(" ");
	//24
	    String[] command24=("CREATE POWER STATION "+id1+"REFERENCE "+coordinates_world+"DELTA "+coordinates_delta+"WITH SUBSTATION").split(" ");
	    String[] command242=("CREATE POWER STATION "+id1+"REFERENCE "+id2+"DELTA "+coordinates_delta+"WITH SUBSTATION").split(" ");
	    String[] command243=("CREATE POWER STATION "+id1+"REFERENCE "+coordinates_world+"DELTA "+coordinates_delta+"WITH SUBSTATIONS").split(" ");
	    String[] command244=("CREATE POWER STATION "+id1+"REFERENCE "+id2+"DELTA "+coordinates_delta+"WITH SUBSTATIONS").split(" ");
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
	    else if(this.commandText.equalsIgnoreCase(Arrays.toString(command43)) || this.commandText.equalsIgnoreCase(Arrays.toString(command432))) {
	    	A_Command command=new CommandCreateTrackCurve(id, coordinates_world, coordinates_delta1, coordinates_delta2, number);
	    	this.parserHelper.getActionProcessor().schedule(command);
	    }
	    else if(this.commandText.equalsIgnoreCase(Arrays.toString(command433)) || this.commandText.equalsIgnoreCase(Arrays.toString(command434))) {
	    	A_Command command=new CommandCreateTrackCurve(id, coordinates_world, coordinates_delta1, coordinates_delta2, coordinates_delta3);
	    	this.parserHelper.getActionProcessor().schedule(command);
	    	
	    }
	    else if(this.commandText.equalsIgnoreCase(Arrays.toString(command6))) {
	    	A_Command command=new CommandBehavioralSelectBridge(id, true);
	    	this.parserHelper.getActionProcessor().schedule(command);
	    }
	    else if(this.commandText.equalsIgnoreCase(Arrays.toString(command61))) {
	    	A_Command command=new CommandBehavioralSelectBridge(id, true);
	    	this.parserHelper.getActionProcessor().schedule(command);
	    }
	    else if(this.commandText.equalsIgnoreCase(Arrays.toString(command22))) {
	    	A_Command command=new CommandCreatePowerCatenary(id, idpoles);
	    	this.parserHelper.getActionProcessor().schedule(command);
	    }
	    else if(this.commandText.equalsIgnoreCase(Arrays.toString(command23))) {
	    	A_Command command=new CommandCreatePowerPole(id, START);
	    	this.parserHelper.getActionProcessor().schedule(command);
	    }
	    else if(this.commandText.equalsIgnoreCase(Arrays.toString(command232))) {
	    	A_Command command=new CommandCreatePowerPole(id, STOP);
	    	this.parserHelper.getActionProcessor().schedule(command);
	    }
	    else if(this.commandText.equalsIgnoreCase(Arrays.toString(command24)) || this.commandText.equalsIgnoreCase(Arrays.toString(command243))) {
	    	A_Command command=new CommandCreatePowerStation(id, coordinates_world, coordinates_delta1, idSubstations);
	    	this.parserHelper.getActionProcessor().schedule(command);
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
	public double getNumber() {
		return this.number;
	}
	public LinkedList getpoles() {
		return this.idpoles;
	}
	public String getId1() {
		return this.id1;
	}
	public String getIdn() {
		return idn;
	}
}

