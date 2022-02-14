package com.kw.taskmanager.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kw.taskmanager.models.Task;

@Repository
public interface TaskRepo extends CrudRepository<Task, Long> {
	
	List<Task> findAll();
	
	void deleteById(Long id);
	
	Task save(Task x);
	
	Optional<Task> findById(Long id);
	
}
