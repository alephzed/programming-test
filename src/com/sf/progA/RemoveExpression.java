package com.sf.progA;

/**
 * This is the concrete REMOVE Expression
 * @author Z093603
 *
 */
public class RemoveExpression implements Expression {
	
	private Command removeCommand;
	
	public RemoveExpression(Command command) {
		this.removeCommand = command;
	}

	@Override
	public String interpret(InterpreterContext ic) {
		return ic.depend(removeCommand);
	}

}
