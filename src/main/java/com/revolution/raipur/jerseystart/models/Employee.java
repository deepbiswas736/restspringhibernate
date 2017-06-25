package com.revolution.raipur.jerseystart.models;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy=InheritanceType.JOINED) 
public class Employee extends UserLogin {
	private String name;
	/*@ManyToOne
	private Company company;*/
	@ManyToOne
	private Project project;
	@Embedded
	private Rating rating ;
	@Embedded
	private Salary salary;
	public Employee()
	{
		rating = new Rating();
		rating.setValue(10);
		salary = new Salary();
		salary.setAmount(0);
	}
	
	public Rating getRating() {
		return rating;
	}
	public void setRating(Rating rating) {
		this.rating = rating;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/*public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}*/
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	
	public Salary getSalary() {
		return salary;
	}
	public void setSalary(Salary salary) {
		this.salary = salary;
	}
	
	
	
	
}
