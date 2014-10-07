package com.sf.progA;

import org.apache.commons.lang3.ArrayUtils;

public class Command {
	private String command;
	private String[] args;
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public String[] getArgs() {
		return args;
	}
	public void setArgs(String[] args) {
		this.args = args;
	}
	
	public String toString() {
		return new StringBuffer( command + " " + ArrayUtils.toString(args)).toString()
				.replace('{', ' ').replace(',', ' ').replaceAll("}", "");
	}
}
