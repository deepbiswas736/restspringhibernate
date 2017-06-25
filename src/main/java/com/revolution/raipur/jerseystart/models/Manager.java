package com.revolution.raipur.jerseystart.models;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
@Entity
public class Manager extends Developer{
	@OneToMany
	private Collection<Developer> developerList= new ArrayList<Developer>();

	public Collection<Developer> getDeveloperList() {
		return developerList;
	}

	public void setDeveloperList(Collection<Developer> developerList) {
		this.developerList = developerList;
	}
	

}
