package com.hashedin.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlInverseReference;

@XmlRootElement
@Entity
@Table(name = "projects")
@NamedQueries({ @NamedQuery(name = "Project.findAll", query = "SELECT p FROM Project p") })
public class Project {

	@Id
	@GeneratedValue
	private Long projectId;
	private String proTitle;

	@XmlInverseReference(mappedBy = "project")
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "project", targetEntity = Task.class)
	private List<Task> tasks;

	public String getProTitle() {
		return proTitle;
	}

	public void setProTitle(String proTitle) {
		this.proTitle = proTitle;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long proID) {
		this.projectId = proID;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

}
