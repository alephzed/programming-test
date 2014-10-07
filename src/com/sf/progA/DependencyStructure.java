package com.sf.progA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Singleton class to store the dependency hierarchy and to provide access to it
 * @author Adam Lee
 *
 */
public class DependencyStructure {

	private static DependencyStructure instance = null;
	private Map<String, List<String>> dependencyMap;
	private List<String> installedComponents;
	
	public List<String> getInstalledComponents() {
		return installedComponents;
	}

	public void setInstalledComponents(List<String> installedComponents) {
		this.installedComponents = installedComponents;
	}

	protected DependencyStructure() {
		dependencyMap = new HashMap<String, List<String>>();
		installedComponents = new ArrayList<String>();
	}
	
	public static DependencyStructure getInstance() {
		if (instance == null) {
			instance = new DependencyStructure();
		}
		
		return instance;
	}
		
	public Map<String, List<String>> getDependencyMap() {
		return dependencyMap;
	}

	public void setDependencyMap(Map<String, List<String>> dependencyMap) {
		this.dependencyMap = dependencyMap;
	}
	
	

}
