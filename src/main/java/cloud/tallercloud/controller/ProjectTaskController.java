package cloud.tallercloud.controller;

import cloud.tallercloud.commons.FormatParser;
import cloud.tallercloud.helpers.Response;
import cloud.tallercloud.helpers.ResponseBuild;
import cloud.tallercloud.persistence.entity.ProjectTask;
import cloud.tallercloud.services.BacklogService;
import cloud.tallercloud.services.ProjectService;
import cloud.tallercloud.services.ProjectTaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class ProjectTaskController {

    private final ProjectTaskService projectTaskService;
    private final ProjectService projectService;
    private final BacklogService backlogService;

    private final ResponseBuild builder;
    private final FormatParser formatParser;

    @PostMapping
    public Response save(@Valid @RequestBody ProjectTask projectTask, BindingResult result) {
        if (result.hasErrors()) {
            return builder.failed(formatParser.formatMessage(result));
        }
        if(projectService.findProjectByProjectIdentifier(projectTask.getProjectIdentifier()).isEmpty()){
            return builder.badRequest();
        }
        if(backlogService.findBacklogById(projectTask.getBacklog().getId())){
            return builder.badRequest();
        }

        try {
            projectTaskService.save(projectTask);
        }catch (Exception e){
            return builder.badRequest();
        }

        return builder.success(projectTask);
    }

    @GetMapping
    public List<ProjectTask> findAll(){
        return this.projectTaskService.findAll();
    }

    @GetMapping("/project/{projectIdentifier}")
    public List<ProjectTask> findTaskAll(@PathVariable("projectIdentifier") String projectIdentifier){
        return this.projectTaskService.findTaskByProject(projectIdentifier);
    }

    @GetMapping("/project/hours/{projectIdentifier}")
    public Response GetHours(@PathVariable("projectIdentifier") String projectIdentifier){
        try {
            return builder.doubleValue(this.projectTaskService.findHoursProject(projectIdentifier));
        }catch (Exception e){
            return builder.noFound();
        }
    }

    @GetMapping("/project/hours/{projectIdentifier}/{status}")
    public Response GetHoursStatus(@PathVariable("projectIdentifier")String projectIdentifier,
                                 @PathVariable("status") String status){
        try {
            return builder.doubleValue(this.projectTaskService.findHoursProjectByStatus(projectIdentifier,status));
        }catch (Exception e){
            return builder.noFound();
        }

    }

    @PatchMapping("/{idtask}/{projectIdentifier}")
    public Response PatchStatusToDeleted(@PathVariable("idtask") Long idtask,
                                     @PathVariable("projectIdentifier") String projectidentifier){
        try {
            this.projectTaskService.deleteTaskStatus(idtask,projectidentifier);
            return builder.logicalDeleteSuccess();
        }catch (Exception e){
            return builder.noFound();
        }

    }
}

