package com.sf.progA;

import org.apache.commons.lang3.ArrayUtils;

/**
 * This is the concrete DEPEND Expression
 * @author Z093603
 *
 */
public class DependExpression implements Expression {
	
	private Command dependCommand;
	
	public DependExpression(Command command) {
		this.dependCommand = command;
	}

	@Override
	public String interpret(InterpreterContext ic) {
		
		// TODO Auto-generated method stub
		//return ic.depend(args);
		return ic.depend(dependCommand);
	}
	
	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append(dependCommand.getCommand() + " ");
		
		return new StringBuffer( dependCommand.getCommand() + " " + ArrayUtils.toString(dependCommand.getArgs())).toString()
				.replace('{', ' ').replace(',', ' ').replaceAll("}", "");
	}

}
