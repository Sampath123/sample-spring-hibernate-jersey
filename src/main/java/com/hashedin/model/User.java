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
@Table(name = "users")
@NamedQueries({ @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u") })
public class User {
	@Id
	@GeneratedValue
	private Long userId;
	private String userName;
	@XmlInverseReference(mappedBy = "assignedTo")
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "assignedTo", targetEntity = Task.class)
	private List<Task> tasks;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long uId) {
		this.userId = uId;
	}

}
