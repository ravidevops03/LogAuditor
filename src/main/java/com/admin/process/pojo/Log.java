package com.admin.process.pojo;

/***
 * 
 * @author Ravi
 * This is POJO class 
 *
 */

public class Log {
	private String id;
	private String state;
	private String type;
	private String host;
	private long timestamp;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "[ " + this.getId() + " | " + this.getState() + " ]";
	}
	
	
}
