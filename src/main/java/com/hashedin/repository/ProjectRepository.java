package com.hashedin.repository;

import java.util.List;

import com.hashedin.model.Project;
import com.hashedin.model.Task;

public interface ProjectRepository {
	Project find(Long proId);

	List<Project> findAll();

	Project save(Project project);

	Project update(Project project, Long proId);

	Project delete(Long proId);

	List<Task> findTasksForProject(long proId);

}
