package com.sf.progA;

/**
 * This is the concrete END Expression
 * @author Z093603
 *
 */
public class EndExpression implements Expression {
	
	private Command endCommand;
	
	public EndExpression(Command command) {
		this.endCommand = command;
	}

	@Override
	public String interpret(InterpreterContext ic) {
		return ic.end(endCommand);
	}

}
