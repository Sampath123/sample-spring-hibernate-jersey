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
@Table(name = "users")
@NamedQueries({ @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u") })
public class User {
	@Id
    @GeneratedValue
    @Column(name = "USER_ID", unique = true, nullable = false)
    private Long userId;
    private String userName;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "assignedTo")
    private Set<Task>tasks;           

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}
	
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long uId) {
		this.userId = uId;
	}

}
