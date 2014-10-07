package com.sf.progA;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import com.sf.progA.Command;

/**
 * Class implementing the Gang of Four Interpreter Design Pattern to process the commands
 * @author Adam Lee
 *
 */
public class Driver {
	
	private InterpreterContext context;
	
	public Driver( InterpreterContext ic) {
		this.context = ic;
	}

	public static void main(String [] args) {
		String fileName = args[0];
		Driver driver = new Driver( new InterpreterContext());
		List<Command> commands = driver.loadCommands(fileName);
		for ( Command command : commands) {
			String result = driver.interpret(command);
			System.out.println(result);
		}
 	}
	
	// Run the commands
	public String interpret( Command command) {
		
		Expression exp = null;
		String result = null;
		if ( command.getCommand().equals("DEPEND") ) {
			exp = new DependExpression(command);
		} else if ( command.getCommand().equals("INSTALL")) {
			exp = new InstallExpression(command);
		} else if ( command.getCommand().equals("REMOVE")) {
			exp = new RemoveExpression(command);
		} else if ( command.getCommand().equals("LIST")) {
			exp = new ListExpression(command);
		} else if ( command.getCommand().equals("END")) {
			exp = new EndExpression(command);
		} else {
			return "command not recognized";
		}
		if (exp != null) {
			exp.interpret(context);
		}
		return exp.toString();
	}
	
	/**
	 * Read the input file and parse into Command Objects
	 * @param fileName
	 * @return
	 */
	private List<Command> loadCommands( String fileName) {
		List<Command> commands = new ArrayList<Command>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName),
                    Charset.defaultCharset());
            for (String line : lines) {
            	String[] result = line.split("\\s+");
            	Command cmd = new Command();
            	cmd.setCommand(result[0]);
            	cmd.setArgs(ArrayUtils.subarray(result, 1, result.length));
            	commands.add(cmd);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return commands;
	}
}
