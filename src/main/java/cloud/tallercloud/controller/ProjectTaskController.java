package cloud.tallercloud.controller;

import cloud.tallercloud.persistence.entity.ProjectTask;
import cloud.tallercloud.persistence.entity.TaskStatus;
import cloud.tallercloud.services.ProjectTaskService;
import cloud.tallercloud.services.dto.ProjectTaskInDTO;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class ProjectTaskController {

    private final ProjectTaskService projectTaskService;

    @PostMapping
    public ProjectTask createProjectTask(@RequestBody ProjectTaskInDTO projectTaskInDTO){
        return this.projectTaskService.createProjectTask(projectTaskInDTO);
    }

    @GetMapping
    public List<ProjectTask> findAll(){
        return this.projectTaskService.findAll();
    }

    @GetMapping("/status/{status}")
    public List<ProjectTask> findAllByTaskStatus(@PathVariable("status") TaskStatus taskStatus){
        return this.projectTaskService.findAllByTaskStatus(taskStatus);
    }

    /*Patch para solo modificar un solo campo , no todos*/
    @PatchMapping("/mark_as_inProgress/{id}")
    public ResponseEntity<Void> markProjectTaskAsInProgress(@PathVariable ("id") Long id){
        this.projectTaskService.updateProjectTaskInProgress(id);
        return ResponseEntity.noContent().build();
    }
}
