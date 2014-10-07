package com.sf.progA;

/**
 * This is the concrete LIST Expression
 * @author Adam Lee
 *
 */
public class ListExpression implements Expression {
	
	private Command listCommand;
	
	public ListExpression(Command command) {
		this.listCommand = command;
	}

	@Override
	public String interpret(InterpreterContext ic) {
		return ic.list(listCommand);
	}
	
	@Override
	public String toString() {
		return listCommand.toString();
	}

}
