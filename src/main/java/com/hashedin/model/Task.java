package com.hashedin.model;

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
public class Task
{

    @Id
    @GeneratedValue
    private Long id;
    private String startDate;
    private String endDate;
    private String title;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PROJECT_ID", nullable = false)
    private Project project;
    @ManyToOne
	@JoinColumn(name = "USER_ID", nullable = false)
    private User assignedTo;
    public Long getId()
    {
        return id;
    }
    public String getTitle()
    {
        return title;
    }
    public void setId(Long id)
    {
        this.id = id;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }	
    public User getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(User assignedTo) {
		this.assignedTo = assignedTo;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}	 
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
}