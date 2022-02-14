package com.kw.taskmanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kw.taskmanager.models.Task;
import com.kw.taskmanager.repositories.TaskRepo;

@Service
public class TaskService {

	private final TaskRepo taskRepo;
	public TaskService(TaskRepo taskRepo) {
		this.taskRepo = taskRepo;
	}
	
	// find all records
	
	public List<Task> findAllTasks() {
		return taskRepo.findAll();
	}
	
	// find one record
	
    public Task findTaskById(Long id) {
    	Optional<Task> t = taskRepo.findById(id);
    	
    	if(t.isPresent()) {
            return t.get();
    	} else {
    	    return null;
    	}
    }
    
    
    // save Task to database
    
    public Task saveTask(Task task) {
    	return taskRepo.save(task);
    }
    
    // delete one Task
    
    public void deleteTask(Long id) {
    	taskRepo.deleteById(id);
    }
	
}
