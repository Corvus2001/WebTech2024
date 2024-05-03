package de.htwberlin.webtech.web;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

@Service
public class TaskService {
    private List<Task> tasks = new ArrayList<>();

    public TaskService() {
        // Initialize with an example task
        tasks.add(new Task(1, "Complete the project", "Finish the coding part of the Spring Boot project.", false, new Date()));
    }

    public List<Task> findAll() {
        return tasks;
    }

    public Task findById(int id) {
        return tasks.stream()
                .filter(task -> task.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Task save(Task task) {
        task.setId(tasks.size() + 1);  // simple logic to set a new ID
        tasks.add(task);
        return task;
    }

    public Task update(int id, Task updatedTask) {
        Task task = findById(id);
        if (task != null) {
            task.setTitle(updatedTask.getTitle());
            task.setDescription(updatedTask.getDescription());
            task.setDone(updatedTask.getDone());
            task.setDueDate(updatedTask.getDueDate());
        }
        return task;
    }

    public boolean delete(int id) {
        return tasks.removeIf(task -> task.getId() == id);
    }
}

