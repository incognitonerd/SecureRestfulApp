package com.securerestfulservices.dto.entities.tables;
public class AvailableEndpoint {
	private int id;
	private String endpointUrl;
	private String endpointQuery;
	private String description;
	private String name;
	
	public AvailableEndpoint(int id, String endpointUrl, String endpointQuery, String description, String name){
		this.id = id;
		this.endpointUrl = endpointUrl;
		this.endpointQuery = endpointQuery;
		this.description = description;
		this.name = name;
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public String getEndpointUrl(){
		return endpointUrl;
	}
	
	public void setEndpointUrl(String endpointUrl){
		this.endpointUrl = endpointUrl;
	}
	
	public String getEndpointQuery(){
		return endpointQuery;
	}
	
	public void setEndpointQuery(String endpointQuery){
		this.endpointQuery = endpointQuery;
	}
	
	public String getDescription(){
		return description;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
}
