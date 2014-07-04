package com.hashedin.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "projects")
@NamedQueries({ @NamedQuery(name = "Project.findAll", query = "SELECT p FROM Project p") })
public class Project {
	
	@Id
    @GeneratedValue
    private Long projectId;
	private String proTitle;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "project")
	private Set<Task>tasks;
	
	public String getProTitle() {
		return proTitle;
	}
	public void setProTitle(String proTitle) {
		this.proTitle = proTitle;
	}
	@Column(name = "PROJECT_ID", unique = true, nullable = false)
	public Long getProjectId() {
		return projectId;
	}
	public void setProjectId(Long proID) {
		this.projectId = proID;
	}
	
	public Set<Task> getTasks() {
		return tasks;
	}
	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}
	
	
	

}
