package com.hashedin.repository;

import java.util.List;

import com.hashedin.model.Project;

public interface ProjectRepository {
	 Project find(Long proId);
	    List<Project> findAll();
	    Project save(Project  project);
	    Project update(Project project, Long proId);
	    Project delete(Long proId);

}
