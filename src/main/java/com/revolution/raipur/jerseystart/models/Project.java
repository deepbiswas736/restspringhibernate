package com.revolution.raipur.jerseystart.models;



import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Project {
	@Id 
	private String projectID;
	private String customerName;
	/*@ManyToOne
	private Company company;*/
	@OneToMany(mappedBy="project")  
	private Collection<Employee> employeeList = new ArrayList<Employee>();
	@ManyToMany
	private Collection<Resource> resourceList = new ArrayList<Resource>();
	@Embedded
	private Collection<Payment> paymentlist = new ArrayList<Payment>();
	public String getProjectID() {
		return projectID;
	}
	public void setProjectID(String projectID) {
		this.projectID = projectID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	/*public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}*/
	public Collection<Employee> getEmployeeList() {
		return employeeList;
	}
	public void setEmployeeList(Collection<Employee> employeeList) {
		this.employeeList = employeeList;
	}
	public Collection<Resource> getResourceList() {
		return resourceList;
	}
	public void setResourceList(Collection<Resource> resourceList) {
		this.resourceList = resourceList;
	}
	public Collection<Payment> getPaymentlist() {
		return paymentlist;
	}
	public void setPaymentlist(Collection<Payment> paymentlist) {
		this.paymentlist = paymentlist;
	}
}
