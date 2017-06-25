package com.revolution.raipur.jerseystart.models;


import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;



@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Developer extends Employee{
	@ManyToOne
	private Manager manager=null;
	@ManyToMany
	private Collection<Resource> resourceList= new ArrayList<Resource>();
	@ManyToOne
	private HR hr;
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	public Collection<Resource> getResourceList() {
		return resourceList;
	}
	public void setResourceList(Collection<Resource> resourceList) {
		this.resourceList = resourceList;
	}
	public HR getHr() {
		return hr;
	}
	public void setHr(HR hr) {
		this.hr = hr;
	}
	
	
}
