package com.reynolds.lawrence.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents a row of data from a parsed CSV file.
 * @author lawrencereynolds
 *
 */
public class CsvRow {

	private int identifier = -1;
	private boolean decision = false;
	private Map<String, Long> variables = new HashMap<String, Long>();
	
	public int getIdentifier() {
		return identifier;
	}
	public void setIdentifier(int identifier) {
		this.identifier = identifier;
	}
	public boolean isDecision() {
		return decision;
	}
	public int getDecisionAsInt(){
		int value = 0;
		if(decision){
			value = 1;
		}
		return value;
	}
	public void setDecision(boolean decision) {
		this.decision = decision;
	}
	public Map<String, Long> getVariables() {
		return variables;
	}
	public void setVariables(Map<String, Long> variables) {
		this.variables = variables;
	}
}
