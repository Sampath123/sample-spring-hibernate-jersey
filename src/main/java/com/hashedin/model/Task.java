package com.hashedin.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "tasks")
@NamedQueries({ @NamedQuery(name = "Task.findAll", query = "SELECT t FROM Task t") })
public class Task {

	@Id
	@GeneratedValue
	private Long taskId;
	private Date startDate;
	private Date endDate;
	private String title;
	private String priority;
	private String status;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "projectId", nullable = false, referencedColumnName = "projectId")
	private Project project;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId", nullable = false, referencedColumnName = "userId")
	private User assignedTo;

	public Long getTaskId() {
		return taskId;
	}

	public String getTitle() {
		return title;
	}

	public void setTaskId(Long id) {
		this.taskId = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public User getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(User assignedTo) {
		this.assignedTo = assignedTo;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}