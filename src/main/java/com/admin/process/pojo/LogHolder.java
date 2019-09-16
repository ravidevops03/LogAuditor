package com.admin.process.pojo;

import java.util.HashMap;
import java.util.Map;

/***
 * 
 * @author Ravi
 * This class holds instances of StartMap and FinishMap.
 * 
 */

public class LogHolder {
	private Map<String, Log> startMap = new HashMap<String, Log>();
	private Map<String, Log> FinishMap = new HashMap<String, Log>();
	
	public Map<String, Log> getStartMap() {
		return startMap;
	}
	public void setStartMap(Map<String, Log> startMap) {
		this.startMap = startMap;
	}
	public Map<String, Log> getFinishMap() {
		return FinishMap;
	}
	public void setFinishMap(Map<String, Log> finishMap) {
		FinishMap = finishMap;
	}
}
