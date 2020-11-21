package cs350f20project.controller.cli.parser;
import cs350f20project.controller.ActionProcessor;
import cs350f20project.controller.Controller;
import cs350f20project.controller.cli.CommandLineInterface;
import cs350f20project.controller.command.A_Command;

public class tester {

	public static void main(String[] args) {
		Controller controller=new Controller();
		CommandLineInterface command=new CommandLineInterface(controller);
		ActionProcessor action=new ActionProcessor(command);
		MyParserHelper parser=new MyParserHelper(action);
		CommandParser obj=new CommandParser(parser, "DO BRAKE id");
		cs350f20project.Startup obj1=new cs350f20project.Startup();
		
		 //obj1.go();
		
	     obj.parse();
       
	}
	

}
