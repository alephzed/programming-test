package com.sf.progA;

/**
 * This is the concrete DEPEND Expression
 * @author Adam Lee
 *
 */
public class InstallExpression implements Expression {
	
	private Command  installCommand;
	
	public InstallExpression(Command command) {
		this.installCommand = command;
	}

	@Override
	public String interpret(InterpreterContext ic) {
		return ic.install(installCommand);
	}
	
	@Override
	public String toString() {
		return installCommand.toString();
	}

}
