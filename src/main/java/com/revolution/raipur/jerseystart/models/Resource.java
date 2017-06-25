package com.revolution.raipur.jerseystart.models;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Resource {
	@Id @GeneratedValue
	private long resourceID;
	private String name;
	private double cost;
	@ManyToOne
	private Admin admin;
	@ManyToMany
	private Collection<Project> projectList = new ArrayList<Project>();
	@ManyToMany
	private Collection<Developer> developerList = new ArrayList<Developer>();
	
	
	public Collection<Developer> getDeveloperList() {
		return developerList;
	}
	public void setDeveloperList(Collection<Developer> developerList) {
		this.developerList = developerList;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	public long getResourceID() {
		return resourceID;
	}
	public void setResourceID(long resourceID) {
		this.resourceID = resourceID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public Collection<Project> getProjectList() {
		return projectList;
	}
	public void setProjectList(Collection<Project> projectList) {
		this.projectList = projectList;
	}
	
}
