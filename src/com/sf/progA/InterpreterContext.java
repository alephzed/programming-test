package com.sf.progA;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

public class InterpreterContext {

	public String depend( Command command ) {
		String args[] = command.getArgs();
		String item1 = args[0];
		List<String> dependencies = Arrays.asList(ArrayUtils.subarray(args, 1, args.length));
		//String dependencies = 
		DependencyStructure.getInstance().getDependencyMap().put(item1, dependencies);
		return "running depend: ";// + args;
	}
	
	public String install( Command command ) {
		String installee = command.getArgs()[0];
		List<String> dependencies = DependencyStructure.getInstance().getDependencyMap().get(installee);
		List<String> installedList = DependencyStructure.getInstance().getInstalledComponents();
		boolean checkFlag = true;
		if (dependencies != null) {
		for (String depency : dependencies) {
			if (!installedList.contains(depency)) {
				checkFlag = false;
				break;
			}
		}
		if (checkFlag == true && !installedList.contains(installee)) {
			installedList.add(installee);
		}
		} else {
			installedList.add(installee);
		}
		return "running install: ";// + args;
	}
	
	public String remove( Command command ) {
		List<String> installedList = DependencyStructure.getInstance().getInstalledComponents();
		if (installedList.contains(command.getCommand())) {
			//TODO handle dependencies
			installedList.remove(command);
		}
		return "running remove: ";// + args;
	}
	
	public String list( Command command ) {
		//TODO generate Lit
		return "running list: ";// + args;
	}
	
	public String end( Command command ) {
		return "end";
	}
}
