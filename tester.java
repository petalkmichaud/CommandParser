package cs350f20project.controller.cli.parser;
import java.util.Arrays;

import cs350f20project.controller.ActionProcessor;
import cs350f20project.controller.Controller;
import cs350f20project.controller.cli.CommandLineInterface;
import cs350f20project.controller.command.A_Command;
import cs350f20project.datatype.CoordinatesDelta;
import cs350f20project.datatype.CoordinatesWorld;

public class tester {

	public static void main(String[] args) {
		
		Controller controller=new Controller();
		CommandLineInterface command=new CommandLineInterface(controller);
		ActionProcessor action=new ActionProcessor(command);
		MyParserHelper parser=new MyParserHelper(action);
		
		String[] jesusThisIsHard=("Do Break "+CommandParser.id).split(" ");
		String commandText=Arrays.toString(jesusThisIsHard);
	    commandText="COMMIT";
		CommandParser obj=new CommandParser(parser, commandText);
		cs350f20project.Startup obj1=new cs350f20project.Startup();
		String id=obj.getID();
		CoordinatesWorld coordinates_world=obj.getWorldCoordinates();
		CoordinatesDelta coordinates_delta1=obj.getStartCoordinates();
		CoordinatesDelta coordinates_delta2=obj.getEndCoordinates();
		String[] command44=("CREATE TRACK "+id+"REFERENCE "+coordinates_world+"DELTA START "+coordinates_delta1+"END "+coordinates_delta2).split(" ");
		commandText=Arrays.toString(command44);
		obj= new CommandParser(parser, commandText);
		 //obj1.go();
		
	     obj.parse();
       
	}
	

}
